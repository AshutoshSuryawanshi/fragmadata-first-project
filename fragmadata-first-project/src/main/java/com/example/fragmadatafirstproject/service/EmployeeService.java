package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;

import com.example.fragmadatafirstproject.dto.EmployeeDto;
import com.example.fragmadatafirstproject.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(EmployeeDto emps);

	public List<Employee> getEmployeeList();

	public Optional<Employee> getSingleEmployeeData(int employeeId);

	public List<Employee> getActiveEmployee();

}
