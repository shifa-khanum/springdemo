package com.example.demo_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_springboot.entity.Employee;
import com.example.demo_springboot.exception.AgeException;
import com.example.demo_springboot.exception.MaximumLengthExceededException;
import com.example.demo_springboot.exception.UserAlreadyExistException;
import com.example.demo_springboot.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee ent) throws MaximumLengthExceededException,UserAlreadyExistException,AgeException {
		if(repo.existsById(ent.getId())) {
			throw new UserAlreadyExistException();
		}
		if(ent.getAge()<18) {
			throw new AgeException();
		}
		if(ent.getName().length()>7) {
			throw new MaximumLengthExceededException();
		}
		Employee savedEmp=repo.save(ent);
		return savedEmp ;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=repo.findAll();

		return employees ;
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		Optional<Employee> emp=repo.findById(id);

		return emp ;
	}

	@Override
	public String deleteById(int id) {
		Optional<Employee> emp=repo.findById(id);
		if(emp.isPresent()) {
			repo.deleteById(id);
			return "Deleted Successfully";
		}
		return "Id Doesn't Exist";	
		
	}

	@Override
	public Employee updateEmployee(Employee ept) {
		Employee update=repo.save(ept);
		return update ;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> list=repo.getEmployeeByName(name);
		return list;
	}

	@Override
	public List<Employee> getEmployeeAboveAge(int age) {
		List<Employee> list=repo.getEmployeeAboveAge(age);
		return list;
	}

}
