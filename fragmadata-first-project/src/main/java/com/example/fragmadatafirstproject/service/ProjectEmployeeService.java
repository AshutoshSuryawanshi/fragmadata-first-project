package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;

import com.example.fragmadatafirstproject.dto.ProjectEmployeeDto;
import com.example.fragmadatafirstproject.model.ProjectEmployee;

public interface ProjectEmployeeService {

	public ProjectEmployee saveProjectEmployee(ProjectEmployeeDto projectEmployeeDto);

	public List<ProjectEmployee> getProjectEmployeeList();

	public ProjectEmployee updateEmployeeData(ProjectEmployee projectEmployee);

	public Optional<ProjectEmployee> getSingleProjectData(int projectId);

	public ProjectEmployee updateEndDate(Optional<ProjectEmployee> projectEmployee);

}
