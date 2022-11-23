package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;

import com.example.fragmadatafirstproject.model.Employee;



public interface EmployeeService {
	
	public Employee saveEmployee(Employee id);
	
	public List<Employee> getEmployeeList();

	public void deltEmployee(Integer lid);

	public Employee updateEmployeeData(Integer lid, Employee e);

	public Optional<Employee> getSingleEmployeeData(int employee_id);

	public List<Employee> getActiveEmployee();

	

}
