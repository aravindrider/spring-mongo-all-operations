package com.spring.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.mongo.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>{

	public List<Employee> findByAddressCity(String city);
	
}
