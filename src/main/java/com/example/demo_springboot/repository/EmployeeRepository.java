package com.example.demo_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_springboot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	@Query("select e from Employee e where e.name=:fname")
	public List<Employee> getEmployeeByName(@Param("fname") String name);
	@Query("select e from Employee e where e.age>:age")
	public List<Employee> getEmployeeAboveAge(@Param("age") int age);

}
