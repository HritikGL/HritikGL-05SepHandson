package com.example.demo.controller;

import java.util.HashMap;  
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee>emp = employeeRepository.findById(id);
			
		return emp;
	}
	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
		Optional<Employee>emp = employeeRepository.findById(id);
		return employeeRepository.save(employee);
		
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id){
		
				
		
		employeeRepository.deleteById(id);
	
	}
	
	
}