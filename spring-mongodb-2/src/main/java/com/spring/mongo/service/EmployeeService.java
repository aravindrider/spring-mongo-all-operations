package com.spring.mongo.service;

import org.springframework.stereotype.Service;

/*import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spring.mongo.entity.Employee;*/

@Service
public class EmployeeService {

	
	/*
	 * @Autowired MongoClient getClient;
	 * 
	 * 
	 * public List<Employee> getAllEmployee(){ MongoDatabase mongoDatabase =
	 * getClient.getDatabase("spring2"); MongoCollection<Document> mongoCollection =
	 * mongoDatabase.getCollection("employee"); List<Employee> employee = new
	 * ArrayList<>(); for(Document e: mongoCollection.find()) { Employee emp = new
	 * Employee(e.get("_id").toString(),e.getString("firstName"),e.getString(
	 * "lastName"),e.getString("address")); employee.add(emp); } return employee; }
	 * 
	 * public String insertEmployee(Employee emp) { MongoDatabase mongoDatabase =
	 * getClient.getDatabase("spring2"); MongoCollection<Document> mongoCollection =
	 * mongoDatabase.getCollection("employee"); Document doc = new Document();
	 * doc.append("firstName",emp.getFirstName());
	 * doc.append("lastName",emp.getLastName());
	 * doc.append("address",emp.getAddress()); try { mongoCollection.insertOne(doc);
	 * return "employee added"; } catch(Exception e) { return "employee added"; } }
	 * 
	 * public String updateEmployee(Employee emp) { MongoDatabase mongoDatabase =
	 * getClient.getDatabase("spring2"); MongoCollection<Document> mongoCollection =
	 * mongoDatabase.getCollection("employee"); Document doc = new Document();
	 * doc.append("firstName",emp.getFirstName());
	 * doc.append("lastName",emp.getLastName());
	 * doc.append("address",emp.getAddress()); try { BasicDBObject filter = new
	 * BasicDBObject("_id",new ObjectId(emp.getId()));
	 * mongoCollection.updateOne(filter, new BasicDBObject("$set",doc)); return
	 * "employee updated"; } catch(Exception e) { return "employee updated"; } }
	 * 
	 * public String deleteEmployee(String id) { MongoDatabase mongoDatabase =
	 * getClient.getDatabase("spring2"); MongoCollection<Document> mongoCollection =
	 * mongoDatabase.getCollection("employee"); try { BasicDBObject filter = new
	 * BasicDBObject("_id",new ObjectId(id)); mongoCollection.deleteOne(filter);
	 * return "employee deleted"; } catch(Exception e) { return "employee deleted";
	 * } }
	 */
		
	
}
