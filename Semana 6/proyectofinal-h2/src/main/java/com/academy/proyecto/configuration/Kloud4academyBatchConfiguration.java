package com.academy.proyecto.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.academy.proyecto.ServiceItemProcessor;
import com.academy.proyecto.bo.ServiceBean;

@Configuration
public class Kloud4academyBatchConfiguration {
	
	@Value("${file.input}")
    private String fileInput;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader reader() {
        return new FlatFileItemReaderBuilder<>()
            .name("serviceItemReader")
            .resource(new ClassPathResource(fileInput))
            .delimited()
            .names(new String[] { "serviceId", "serviceName", "serviceDesc", "cost" })
            .fieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(ServiceBean.class);
            }})
            .build();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Bean
    public JdbcBatchItemWriter writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO service (serviceId, serviceName, serviceDesc, cost) VALUES (:serviceId, :serviceName, :serviceDesc, :cost)")
            .dataSource(dataSource)
            .build();
    }
    
    @Bean
    public Job importUserJob(JobRepository jobRepository, JobExecutionListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(jobCompletionListener())
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public JobExecutionListener jobCompletionListener() {
        return new JobExecutionListenerSupport();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, JdbcBatchItemWriter writer) {
        return new StepBuilder("step1", jobRepository)
            .<ServiceBean, ServiceBean>chunk(5, transactionManager)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }

    @Bean
    public ServiceItemProcessor processor() {
        return new ServiceItemProcessor();
    }



}
