package com.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department,String> {

}
