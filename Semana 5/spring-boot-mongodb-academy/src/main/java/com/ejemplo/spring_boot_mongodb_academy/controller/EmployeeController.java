package com.ejemplo.spring_boot_mongodb_academy.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.spring_boot_mongodb_academy.collection.Employee;
import com.ejemplo.spring_boot_mongodb_academy.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public String save(@RequestBody Employee employee)
	{
	return employeeService.save(employee);
	}
	
	@GetMapping
	public List<Employee>
	getEmployeeStartsWith(@RequestParam String name) {
		return employeeService.getEmployeeStartsWith(name);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees( ) { 
		return employeeService.findAll();
	}
	
	@GetMapping("/oldestEmployee")
	public List<Document> getOldestEmployee() {
	    return employeeService.getOldestEmployeeByCity();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		employeeService.delete(id);
	}
	 // ... otros endpoints ...
}