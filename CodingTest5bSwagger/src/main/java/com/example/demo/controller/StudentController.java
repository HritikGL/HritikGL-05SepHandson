package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class StudentController {

	private List<Student> students = createList();

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public List<Student> firstPage() {
		System.out.println("get operation");
		return students;
	}

	@DeleteMapping( "/students/{id}" )
	public Student delete(@PathVariable("id") String id) {
		System.out.println("delete .."+id);
		Student deletedStd = null;
		System.out.println(students);
		for (Student std : students) {
			
			if (std.getId().equals(id)) {
				System.out.println("id  :  "+ id);
				System.out.println(students.size());
				students.remove(std);
				System.out.println(students.size());
				deletedStd = std;
				break;
			}
		}
		return deletedStd;
	}

	@PostMapping
	public Student create(@RequestBody Student user) {
		
		students.add(user);
		System.out.println(students+"  !!!");
		return user;
	}
	
	
	  @PutMapping("/students/{id}") public Student update(@PathVariable("id")
	  String id,@RequestBody Student user) {
		  students.add(user);
		  System.out.println(students+" Update !!!");
		  return user;
	  
	  
	  }
	 

	private static List<Student> createList() {
		List<Student> tempStudents = new ArrayList<>();
		Student std1 = new Student();
		std1.setName("Ram");
		std1.setStandard("II");
		std1.setId("1");
		std1.setFees(7000);

		Student std2 = new Student();
		std2.setName("Shyam");
		std2.setStandard("IV");
		std2.setId("2");
		std2.setFees(5000);
		
		tempStudents.add(std1);
		tempStudents.add(std2);
		
		return tempStudents;
	}
}