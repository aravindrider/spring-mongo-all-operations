package com.spring.mongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.service.BookService;
import com.spring.mongo.service.BookService2;

@RestController
@RequestMapping("/books")
public class BookController {

	/*
	 * @Autowired private BookService bookServce;
	 * 
	 * @Autowired private BookService2 bookService2;
	 * 
	 * @GetMapping() public List<Document> getBooks(){ return
	 * bookService2.getAllBooks(); }
	 * 
	 * @GetMapping("/countPage") public Map<String,Object> countPage() {
	 * Map<String,Object> map = new HashMap<>(); map.put("Total no of pages",
	 * bookServce.countpage()); return map; }
	 * 
	 * @GetMapping("/categories") public List<Object>
	 * getCatgories(@RequestParam(value = "categories",required = true) String[] arr
	 * ){ return bookServce.getCategories(arr); }
	 * 
	 * @PostMapping public String insertBooks(@RequestBody Map<String,Object> doc) {
	 * return bookServce.insertBook(doc); }
	 * 
	 * @PutMapping public String updateBooks(@RequestBody Map<String,Object> doc) {
	 * return bookServce.updateBook(doc); }
	 * 
	 * @DeleteMapping("delete/{id}") public String deleteBook(@PathVariable String
	 * id) { return bookServce.deleteBook(id); }
	 * 
	 */
}