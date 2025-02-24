package com.academy.proyecto.bo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("servicedata")
public class ServiceBean {
	private String serviceId;
	private String serviceName;
	private String serviceDesc;
	private String cost;

}
