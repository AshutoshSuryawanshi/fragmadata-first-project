package com.example.fragmadatafirstproject.serviceimpl;

import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.model.Project;
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
	public ProjectEmployee saveProjectEmployee(ProjectEmployee prjemp) {
		LocalDate date = LocalDate.now();
		prjemp.getEmployeeId().setCreatedDate(date);
		prjemp.getProjectId().setStartDate(date);
		return er.save(prjemp);
	}

	@Override
	public List<ProjectEmployee> getProjectEmployeeList() {

		return er.findAll();
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

	@Override
	public ProjectEmployee updateEndDate(Project pid, ProjectEmployee pe) {

		Optional<ProjectEmployee> op = er.findByProjectId(pid);

		LocalDate date = LocalDate.now();
		if (op.isPresent()) {
			pe = op.get();
			pe.getProjectId().setEndDate(date);
			pe.setEndDate(pe.getProjectId().getEndDate());
			pe.getProjectId().setStatus("Inactive");
			pe.setStatus(pe.getProjectId().getStatus());
			return er.save(pe);
		} else {
			return null;
		}
	}

}
