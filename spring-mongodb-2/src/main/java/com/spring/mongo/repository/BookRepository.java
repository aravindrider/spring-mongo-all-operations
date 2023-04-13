package com.spring.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongo.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {

	@Query(value = "{\"categories\":{ $elemMatch : {$in:?0} }}" , fields = "{title:1}")
	public List<Book> getCategories(String[] categories);
	
}
