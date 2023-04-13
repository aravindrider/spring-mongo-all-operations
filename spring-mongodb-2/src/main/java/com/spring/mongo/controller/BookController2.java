package com.spring.mongo.controller;

import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.entity.Book;
import com.spring.mongo.repository.BookRepository;
import com.spring.mongo.service.BookService2;

@RestController
@RequestMapping("/book")
public class BookController2 {

	@Autowired
	private BookService2 bookService2;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping()
	public List<Book> getBooks(){
		return bookRepository.findAll();
		// return bookService2.getAllBooks();
	}
	
	@GetMapping("/page")
	public Map<String,Object> getBooksWithPageable(@RequestParam(value = "pageNo") int pageNo,@RequestParam(value = "pageSize") int pageSize,@RequestParam(value = "fields",required = false) String[] fields,@RequestParam(value = "sortBy") String sortBy) {
		return bookService2.getBooksWithPageable(pageNo, pageSize, fields, sortBy);
	}
	
	@GetMapping("/count")
	public Document getCount() {
		return bookService2.count();
	}
	
	@GetMapping("/categories")
	public List<Book> getCategories(@RequestParam(value = "fields")String[] fields){
		return bookService2.getCategories(fields);
	}
	
	@PostMapping
	public Book insertBook(@RequestBody Book book) {
		return bookRepository.insert(book);
	}
	
	@PutMapping
	public Book updateBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
//	@PostMapping
//	public Document insertBook(@RequestBody Map<String,Object> doc) {
//		Document document = new Document(doc);
//		System.err.print(document.toJson());
//		return bookService2.insertBook(document);
//	}

//	@PutMapping
//	public String updateBook(@RequestBody Map<String,Object> doc,@RequestParam String id) {
//		Document document = new Document(doc);
//		System.err.print(document.toJson());
//		return bookService2.updateBook(document, id);
//	}
	
	@DeleteMapping("delete/{id}")
	public String deleteBook(@PathVariable String id)
	{ 
		bookRepository.deleteById(id); 
		return "deleted";
	}
	

//	@DeleteMapping("delete/{id}")
//	public long deleteBook(@PathVariable String id)
//	{ return bookService2.deleteBook(id); }
//	
	

}
