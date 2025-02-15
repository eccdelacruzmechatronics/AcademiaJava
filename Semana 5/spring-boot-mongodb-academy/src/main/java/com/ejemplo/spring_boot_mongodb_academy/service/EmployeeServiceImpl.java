package com.ejemplo.spring_boot_mongodb_academy.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Service;

import com.ejemplo.spring_boot_mongodb_academy.collection.Employee;
import com.ejemplo.spring_boot_mongodb_academy.repository.EmployeeRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository EmployeeRepository;
	 @Autowired
	    private MongoTemplate mongoTemplate;

	@Override
	public String save(Employee employee) {
		EmployeeRepository.save(employee);
		return employee.getEmployeeId();
	}

	@Override
	public List<Employee> getEmployeeStartsWith(String name) {
		return EmployeeRepository.findByFirstNameStartsWith(name);
	}

	@Override
	public List<Employee> findAll() {
		return EmployeeRepository.findAll();
	}
	
	
	@Override
	public void delete(String id) {
		EmployeeRepository.deleteById(id);
	}
	
	 @Override
	    public List<Document> getOldestEmployeeByCity() {
	        UnwindOperation unwindOperation
	                = Aggregation.unwind("addresses"); // agrupacion
	        SortOperation sortOperation
	                = Aggregation.sort(Sort.Direction.DESC,"age"); // orden por edad de forma descendente
	        GroupOperation groupOperation
	                = Aggregation.group("addresses.city")
	                .first(Aggregation.ROOT)
	                .as("oldestEmployee");

	        Aggregation aggregation
	                = Aggregation.newAggregation(unwindOperation,sortOperation,groupOperation);

	        List<Document> employee
	                = mongoTemplate.aggregate(aggregation, Employee.class,Document.class).getMappedResults();
	        return employee;
	    }
 // ... implementación adicional ...
 }
