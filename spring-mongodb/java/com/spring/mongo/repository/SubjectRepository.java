package com.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.entity.Subject;

public interface SubjectRepository extends MongoRepository<Subject,String> {

}
