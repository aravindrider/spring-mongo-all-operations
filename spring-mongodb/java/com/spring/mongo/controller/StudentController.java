package com.spring.mongo.controller;

import java.util.List;

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

import com.spring.mongo.entity.Student;
import com.spring.mongo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{Id}")
	public Student getStudentById(@PathVariable String Id) {
		return studentService.getStudentById(Id);
	}
	
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	
	@GetMapping("/name/{name}")
	public List<Student> getStudentsNameBy(@PathVariable String name){
		return studentService.findStudentByName(name);
	}
	
	@GetMapping("/nameAndEmail")
	public Student getStudentByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentByNameAndEmail(name, email);
	}
	
	@GetMapping("/nameOrEmail")
	public List<Student> getStudentByNameOrEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentByNameOrEmail(name, email);
	}
	
	@GetMapping("/pagination")
	public List<Student> withPagination(@RequestParam int pageNo,@RequestParam int pageSize) {
		return studentService.withPagination(pageNo, pageSize);
	}
	
	@GetMapping("/sorting")
	public List<Student> withSorting(@RequestParam String sortDir,@RequestParam String field) {
		return studentService.sorting(sortDir, field);
	}
	
	@GetMapping("/departmentName")
	public List<Student> getStudentByDepartName(@RequestParam String departmentName){
		return studentService.getDepartNameByDepartment(departmentName);
	}
	
	@GetMapping("/subjectName")
	public List<Student> getStudentBySubjectName(@RequestParam String name){
		return studentService.getStudenyBySubjectName(name);
	}
	
	@GetMapping("/mail")
	public List<Student> getStudenyByMail(@RequestParam String mail){
		return studentService.getStudentByMail(mail);
	}
	
	@GetMapping("/name/startsWith")
	public List<Student> getStudentByNameStartsWith(@RequestParam String name){
		return studentService.getStudentByNameStartsWith(name);
	}
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/department/{id}")
	public List<Student> getStudentByDepartment(@PathVariable String id){
		return studentService.getAllStudentByDepartment(id);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
	
	
		
	
}
