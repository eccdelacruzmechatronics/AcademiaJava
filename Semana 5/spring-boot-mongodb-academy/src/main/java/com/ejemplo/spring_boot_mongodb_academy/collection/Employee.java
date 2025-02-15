package com.ejemplo.spring_boot_mongodb_academy.collection;

import java.util.List; 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Document(collection = "employee")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
 public class Employee {
 	@Id
 	private String employeeId;
 	private String firstName;
 	private String lastName;
 	private Integer age;
 	private List<String> hobbies;
 	private List<Address> addresses;
 }

