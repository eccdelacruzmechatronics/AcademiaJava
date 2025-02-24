package com.academy.proyecto.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBean {
	private String serviceId;
	private String serviceName;
	private String serviceDesc;
	private String cost;
}
