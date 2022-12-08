package com.example.fragmadatafirstproject.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
			return null;
		}

	}

	@Override
	public ProjectEmployee updateEndDate(Optional<ProjectEmployee> projectEmployee) {

		LocalDate date = LocalDate.now();
		
		if (projectEmployee.isPresent()) {
			ProjectEmployee projEmpUpdate = projectEmployee.get();
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
		return er.findByProjectId(projectId);
	}

}
