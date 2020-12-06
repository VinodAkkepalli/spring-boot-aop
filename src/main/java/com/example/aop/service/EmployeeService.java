package com.example.aop.service;


import org.springframework.stereotype.Service;

import com.example.aop.model.Employee;


@Service
public class EmployeeService {

	public Employee createEmployee(String name, String empId) {

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}

	public void deleteEmployee(String empId) {
		
	}
	
	public void exceptionThrowingEmployee() {
		System.out.println("inside exceptionThrowingEmployee()");
		throw new RuntimeException();
	}
	
	public void workEmployee() {
		System.out.println("I am working!!");
	}
}
