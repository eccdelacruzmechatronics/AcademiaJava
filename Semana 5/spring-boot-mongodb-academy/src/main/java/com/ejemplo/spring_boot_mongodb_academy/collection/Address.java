package com.ejemplo.spring_boot_mongodb_academy.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
	private String address1;
	private String address2;
	private String city;
	}
		
	

