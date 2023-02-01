package com.example.demo_springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.demo_springboot.entity.Employee;
import com.example.demo_springboot.exception.AgeException;
import com.example.demo_springboot.exception.MaximumLengthExceededException;
import com.example.demo_springboot.exception.UserAlreadyExistException;

public interface EmployeeService {
	Employee saveEmployee(Employee ent) throws MaximumLengthExceededException,UserAlreadyExistException, AgeException;

	List<Employee> getAllEmployees();

	Optional<Employee> getEmployeeById(int id);

	String deleteById(int id);

	Employee updateEmployee(Employee ept);

	List<Employee> getEmployeeByName(String name);

	List<Employee> getEmployeeAboveAge(int age);


}
