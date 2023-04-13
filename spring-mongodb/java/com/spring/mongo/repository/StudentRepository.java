

package com.spring.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongo.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

	public List<Student> findByName(String name);
	
	public Student findByNameAndEmail(String name,String email);
	
	public List<Student> findByNameOrEmail(String name,String email);
	
	public List<Student> findByDepartmentDepartmentName(String departmentName);
	
	public List<Student> findBySubjectsSubjectName(String subjectName);
	
	public List<Student> findByEmailIsLike(String email);
	
	public List<Student> findByNameStartsWith (String name);
	
	public List<Student> findByDepartmentId (String id);
	
	@Query("{\"name\":\"?0\"}")
	public List<Student> getStudentByName(String name);
	
}
