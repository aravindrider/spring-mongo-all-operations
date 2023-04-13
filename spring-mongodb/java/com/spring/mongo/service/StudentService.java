package com.spring.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.mongo.entity.Student;
import com.spring.mongo.repository.DepartmentRepository;
import com.spring.mongo.repository.StudentRepository;
import com.spring.mongo.repository.SubjectRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

	public Student createStudent(Student student) {
		if(student.getDepartment()!=null) {
			departmentRepository.save(student.getDepartment());
		}
		if(student.getSubjects()!=null && student.getSubjects().size()>0) {
			subjectRepository.saveAll(student.getSubjects());
		}
		return studentRepository.save(student);
	}
	
	public List<Student> findStudentByName(String name){
		return studentRepository.getStudentByName(name);
	}

	public Student getStudentById(String id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getAllStudents(){
		return studentRepository.findAll();	
	}
	
	public List<Student> getAllStudentByDepartment(String id){
		return studentRepository.findByDepartmentId(id);
	}

	public List<Student> getStudentByName(String name){
		return studentRepository.findByName(name);
	}

	public Student getStudentByNameAndEmail(String name,String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	public List<Student> getStudentByNameOrEmail(String name,String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	public List<Student> withPagination(int pageNo,int PageSize){
		Pageable pageAble = PageRequest.of(pageNo-1, PageSize);
		return studentRepository.findAll(pageAble).getContent();
	}

	public List<Student> sorting(String sortDir,String field){
		Sort sort = Sort.by( sortDir == "ASC" ? Sort.Direction.ASC : Sort.Direction.DESC ,field);
		return studentRepository.findAll(sort);
	}
	
	public List<Student> getDepartNameByDepartment(String departmentName){
		return studentRepository.findByDepartmentDepartmentName(departmentName);
	}
	
	public List<Student> getStudenyBySubjectName(String subjectName){
		return studentRepository.findBySubjectsSubjectName(subjectName);
	}
	
	public List<Student> getStudentByMail(String mail){
		return studentRepository.findByEmailIsLike(mail);
	}
	
	public List<Student> getStudentByNameStartsWith(String name){
		return studentRepository.findByNameStartsWith(name);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "Student Deleted";
	}

}
