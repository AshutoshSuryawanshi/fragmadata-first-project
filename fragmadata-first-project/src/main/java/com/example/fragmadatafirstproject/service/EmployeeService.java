package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;

import com.example.fragmadatafirstproject.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employeeId);

	public List<Employee> getEmployeeList();

	public void deltEmployee(Integer lid);

	public Employee updateEmployeeData(Integer eid, Employee em);

	public Optional<Employee> getSingleEmployeeData(int employeeId);

	public List<Employee> getActiveEmployee();

}
