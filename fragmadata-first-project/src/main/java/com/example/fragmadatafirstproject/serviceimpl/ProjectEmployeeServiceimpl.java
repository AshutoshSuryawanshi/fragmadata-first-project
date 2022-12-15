package com.example.fragmadatafirstproject.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.dto.ProjectEmployeeDto;
import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.repository.ProjectEmployeeRepository;
import com.example.fragmadatafirstproject.service.ProjectEmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@Service
public class ProjectEmployeeServiceimpl implements ProjectEmployeeService {
//	@SuppressWarnings("unused")
	@SuppressWarnings("unused")
	private Logger logger = (Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectEmployeeRepository er;
	
	
	@Autowired
	ModelMapper modelMapper;
	@Override
	public ProjectEmployee saveProjectEmployee(ProjectEmployeeDto projectEmployeeDto) {
		ProjectEmployee projectEmployee = modelMapper.map(projectEmployeeDto, ProjectEmployee.class);
		LocalDate date = LocalDate.now();

		projectEmployee.getEmployeeId().setCreatedDate(date);
		projectEmployee.getProjectId().setStartDate(date);
		projectEmployee.setCreatedDate(date);
		projectEmployee.setStartDate(date);
		projectEmployee.setCreatedBy(projectEmployee.getEmployeeId().getCreatedBy());
		projectEmployee.setStatus(projectEmployee.getProjectId().getStatus());
		
		return er.save(projectEmployee);
	}

	@Override
	public List<ProjectEmployee> getProjectEmployeeList() {

		return er.findAll();
	}

	@Override
	public ProjectEmployee updateEndDate(int projectId) {
		ProjectEmployee projEmpUpdate;
		LocalDate date = LocalDate.now();
		Optional<ProjectEmployee> projectEmployee =er.findById(projectId);
		if (projectEmployee.isPresent()) {
			projEmpUpdate = projectEmployee.get();
			projEmpUpdate.getProjectId().setEndDate(date);
			projEmpUpdate.setEndDate(projEmpUpdate.getProjectId().getEndDate());
			projEmpUpdate.getProjectId().setStatus("Inactive");
			projEmpUpdate.setStatus(projEmpUpdate.getProjectId().getStatus());
			return er.save(projEmpUpdate);
		} else {
			return null;
		}
	}

	@Override
	public Optional<ProjectEmployee> getSingleProjectData(int projectId) {
		return er.findById(projectId);
	}

}
