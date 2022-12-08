package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Employeedemo;

public interface EmployeeService {

	public void saveEmployee(Employeedemo emps);

	public List<Employee> getEmployeeList();

	public Optional<Employee> getSingleEmployeeData(int employeeId);

	public List<Employee> getActiveEmployee();

}
