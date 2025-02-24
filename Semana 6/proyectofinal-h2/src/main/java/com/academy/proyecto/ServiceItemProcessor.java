package com.academy.proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.academy.proyecto.bo.ServiceBean;


public class ServiceItemProcessor implements ItemProcessor<ServiceBean, ServiceBean> {

    private Logger LOGGER = LoggerFactory.getLogger(ServiceItemProcessor.class);

    @Override
    public ServiceBean process(final ServiceBean service) throws Exception {
        String cost = "$" + service.getCost();
        
        ServiceBean transformedService = new ServiceBean(
        		service.getServiceId(), 
        		service.getServiceName(), 
        		service.getServiceDesc(), 
        		cost);
        
        LOGGER.info("Converting ( {} ) into ( {} )", service, transformedService);
        return transformedService;
    }
}
