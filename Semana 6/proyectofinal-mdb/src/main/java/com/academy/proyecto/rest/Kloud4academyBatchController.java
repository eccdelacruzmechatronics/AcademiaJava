package com.academy.proyecto.rest;

import com.academy.proyecto.bo.ServiceBean;
import com.mongodb.bulk.BulkWriteResult;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Kloud4academyBatchController {

    @Value("${file.input}")
    private String fileInput;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/mongodbbulkupdate")
    public String directHomePage() {
        try {
            commitBulkUpdateToMongoDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Mongodb Bulk Update Processed";
    }

    private void commitBulkUpdateToMongoDB() {
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        	CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        	CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();
            int count = 0;
            ServiceBean serviceData = null;
            List<ServiceBean> serviceInfoList = new ArrayList<>();

            for (String[] serviceRow : allData) {
                String[] serviceStringArry = new String[serviceRow.length];
                serviceData = new ServiceBean();
                count = 0;
                for (String serviceInfo : serviceRow) {
                    serviceStringArry[count] = serviceInfo;
                    count++;
                }
                serviceData.setServiceId(serviceStringArry[0]);
                serviceData.setServiceName(serviceStringArry[1]);
                serviceData.setServiceDesc(serviceStringArry[2]);
                serviceData.setCost(serviceStringArry[3]);
                serviceInfoList.add(serviceData);
            }

            BulkOperations bulkOps = 
            		mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, ServiceBean.class);
            serviceInfoList.stream().filter(service -> service != null).forEach(service -> {
                org.bson.Document dbDoc = new org.bson.Document().append("$set", service);
                mongoTemplate.getConverter().write(service, dbDoc);
                Query query = new Query().addCriteria(new Criteria("uuid").is(service.getServiceId()));
                Update update = Update.fromDocument(dbDoc, "");
                bulkOps.upsert(query, update);
            });

            BulkWriteResult result = bulkOps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
