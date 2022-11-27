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
public class ProjectEmployeeServiceimpl implements ProjectEmployeeService {
	@SuppressWarnings("unused")
	private Logger logger = (Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectEmployeeRepository er;

	@Override
	public ProjectEmployee saveProjectEmployee(ProjectEmployee startDate) {

		return er.save(startDate);
	}

	@Override
	public List<ProjectEmployee> getProjectEmployeeList() {

		return er.findAll();
	}

	@Override
	public List<ProjectEmployee> getdata() {
		return er.innerJoinedProjEmp();
	}

	@Override
	public ProjectEmployee updateEmployeeData(ProjectEmployee projemp) {

		Optional<ProjectEmployee> op = er.findById(projemp.getId());
		if (op.isPresent()) {
			projemp = op.get();
			projemp.setCreatedBy(projemp.getEmployeeId().getCreatedBy());
			projemp.setCreatedDate(projemp.getEmployeeId().getCreatedDate());
			projemp.setStartDate(projemp.getProjectId().getStartDate());
			projemp.setEndDate(projemp.getProjectId().getEndDate());
			projemp.setStatus(projemp.getProjectId().getStatus());

			return er.save(projemp);
		} else {
//		logger.info(methodName + "Employee not available");
//		System.out.println("Employee not available");
			return null;
		}

	}

}
