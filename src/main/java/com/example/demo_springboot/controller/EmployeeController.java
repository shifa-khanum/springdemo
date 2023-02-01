package com.example.demo_springboot.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_springboot.entity.Employee;
import com.example.demo_springboot.exception.AgeException;
import com.example.demo_springboot.exception.MaximumLengthExceededException;
import com.example.demo_springboot.exception.UserAlreadyExistException;
import com.example.demo_springboot.service.EmployeeService;

@RestController

public class EmployeeController {
	
	@Autowired
	private EmployeeService serv;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee ent)throws MaximumLengthExceededException,UserAlreadyExistException,AgeException{
		Employee savedEmp=serv.saveEmployee(ent);
		return new ResponseEntity<Employee>(savedEmp,HttpStatus.CREATED);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees=serv.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id){
		Optional<Employee> emp=serv.getEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable int id){
		String msg=serv.deleteById(id);
		return new ResponseEntity<String>(msg,HttpStatus.GONE);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee ept){
		Employee update=serv.updateEmployee(ept);
		return new ResponseEntity<Employee>(update, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name){
		List<Employee> list=serv.getEmployeeByName(name);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAboveAge/{age}")
	public ResponseEntity<List<Employee>> getEmployeeAboveAge(@PathVariable int age){
		List<Employee> list=serv.getEmployeeAboveAge(age);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		
	}
}
