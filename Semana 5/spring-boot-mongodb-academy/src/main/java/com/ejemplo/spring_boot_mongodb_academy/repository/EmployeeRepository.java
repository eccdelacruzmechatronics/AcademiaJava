package com.ejemplo.spring_boot_mongodb_academy.repository;

import java.util.List; 

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ejemplo.spring_boot_mongodb_academy.collection.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {
 // Ejemplo de método de búsqueda personalizado
List<Employee> findByFirstNameStartsWith(String name);
}
