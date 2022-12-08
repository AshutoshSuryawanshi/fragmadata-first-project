package com.example.fragmadatafirstproject.serviceimpl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Employeedemo;
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
	public void saveEmployee(Employeedemo empdemo) {
		try {
			Employee emp =new Employee();
			         emp.setEmployeeId(empdemo.getEmployeeId());
			         emp.setEmployeeName(empdemo.getEmployeeName());
			         emp.setDesignation(empdemo.getDesignation());
			         emp.setJoiningDate(empdemo.getJoiningDate());
			         emp.setEmailId(empdemo.getEmailId());
			         emp.setMobileNo(empdemo.getMobileNo());
			         emp.setGender(empdemo.getGender());
			         emp.setStatus(empdemo.getStatus());
			         emp.setAddress(empdemo.getAddress());
			         emp.setCity(empdemo.getCity());
			         emp.setState(empdemo.getState());
			         emp.setCountry(empdemo.getCountry());
			         emp.setCreatedDate(empdemo.getCreatedDate());
			         emp.setCreatedBy(empdemo.getCreatedBy());
			         
			         
			         er.save(emp);
			
		} catch (Exception e) {
			e.printStackTrace();
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
