package com.example.fragmadatafirstproject.serviceimpl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.model.Project_employee;
import com.example.fragmadatafirstproject.repository.Project_employeeRepository;
import com.example.fragmadatafirstproject.service.Project_employeeService;


@Service
public class Project_employeeServiceimpl implements Project_employeeService{
	@Autowired
	Project_employeeRepository er;

	@Override
	public Project_employee saveProject_employee(Project_employee start_date) {
		
		return er.save(start_date);
	}

	@Override
	public List<Project_employee> getProject_employeeList() {
		
		return er.findAll();
		}
}
