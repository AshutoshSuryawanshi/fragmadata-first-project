package com.example.fragmadatafirstproject.serviceimpl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;
import com.example.fragmadatafirstproject.service.EmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	Logger logger = (Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	EmployeeRepository er;

	@Override
	public Employee saveEmployee(Employee employeeId) {
		try {
			return er.save(employeeId);
		} catch (Exception e) {
			return employeeId;
		}
	}

	@Override
	public List<Employee> getEmployeeList() {

		return er.findAll();
	}

	@Override
	public Optional<Employee> getSingleEmployeeData(int employeeId) {

		return er.findById(employeeId);
	}

	@Override
	public List<Employee> getActiveEmployee() {

		return er.findByStatus("Active");

	}

}
