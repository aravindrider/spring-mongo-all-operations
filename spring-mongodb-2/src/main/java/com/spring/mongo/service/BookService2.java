package com.spring.mongo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.spring.mongo.entity.Book;
import com.spring.mongo.repository.BookRepository;

@Service("bookService2")
public class BookService2 {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Document> getAllBooks(){
		return mongoTemplate.findAll(Document.class,"books");
	}
	
	public Document insertBook(Document doc) {
		return mongoTemplate.insert(doc,"books");
	}
	
	public String updateBook(Document doc,String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new BasicUpdate(doc);
		return "Updated Count"+mongoTemplate.updateFirst(query, update,"books").getModifiedCount();
	}
	
	public long deleteBook(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.remove(query,"books").getDeletedCount();
	}
	
	
	
	public Map<String, Object> getBooksWithPageable(int pageNo,int pageSize,String[] fields,String sortBy){
//		Query query = new Query();
//		for(String field:fields) {
//			query.fields().include(field);
//		}
		Sort sort = Sort.by(sortBy);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//		query.with(pageable);
//		List<Document> doc=mongoTemplate.find(query,Document.class,"books");
//		Page<Document> page=PageableExecutionUtils.getPage(doc, pageable,()-> mongoTemplate.count(query,Document.class));
	    Page<Book> page = bookRepository.findAll(pageable);
		Map<String,Object> response = new HashMap<>();
		response.put("data ",page.getContent());
		response.put("Total pages ",page.getTotalPages());
		response.put("Total Number of Elements",page.getNumberOfElements());
		return response;
	}
	
	public Document count() {
		Aggregation aggregation = Aggregation.newAggregation(Aggregation.group().sum("$pageCount").as("count"));
	    return mongoTemplate.aggregate(aggregation,"books",Document.class).getRawResults();
	}
	
	public List<Book> getCategories(String[] categories) {
		return bookRepository.getCategories(categories);
	}
	
}
