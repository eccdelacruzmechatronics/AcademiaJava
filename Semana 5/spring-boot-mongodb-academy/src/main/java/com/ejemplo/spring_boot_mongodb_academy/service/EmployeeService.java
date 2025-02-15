package com.ejemplo.spring_boot_mongodb_academy.service;

import java.util.List;

import org.bson.Document;

import com.ejemplo.spring_boot_mongodb_academy.collection.Employee;

public interface EmployeeService {
	String save(Employee employee);
	List<Employee> getEmployeeStartsWith(String name);
	void delete(String id);
 // ... otros métodos ...
	List<Employee> findAll();
	List<Document> getOldestEmployeeByCity();

 }
