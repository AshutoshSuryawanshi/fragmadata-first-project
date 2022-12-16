package com.example.fragmadatafirstproject.serviceimpl;

import java.time.LocalDate;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.dto.EmployeeDto;
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

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Employee saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
	
		LocalDate date = LocalDate.now();
		employee.setCreatedDate(date);
		return er.save(employee);
	}

	@Override
	public List<Employee> getEmployeeList() {

		return er.findAll();
	}

	@Override
	public Employee getSingleEmployeeData(int employeeId) {
		return er.findById(employeeId).get();
	}

	@Override
	public List<Employee> getActiveEmployee() {

		return er.findByStatus("Active");

	}

}
