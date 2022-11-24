package com.example.fragmadatafirstproject.serviceimpl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.repository.ProjectEmployeeRepository;
import com.example.fragmadatafirstproject.service.ProjectEmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;


@Service
public class ProjectEmployeeServiceimpl implements ProjectEmployeeService{
	@SuppressWarnings("unused")
	private Logger logger=(Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectEmployeeRepository er;

	
	@Override
	public ProjectEmployee saveProjectEmployee(ProjectEmployee start_date) {
		
		return er.save(start_date);
	}

	@Override
	public List<ProjectEmployee> getProjectEmployeeList() {
		
		return er.findAll();
		}

}
