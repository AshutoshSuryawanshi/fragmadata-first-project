package com.example.fragmadatafirstproject.service;

import java.util.List;

import com.example.fragmadatafirstproject.model.ProjectEmployee;

public interface ProjectEmployeeService {

	public ProjectEmployee saveProjectEmployee(ProjectEmployee startDate);

	public List<ProjectEmployee> getProjectEmployeeList();

	public ProjectEmployee updateEmployeeData(ProjectEmployee projectEmployee);

	public ProjectEmployee updateEndDate(int pid);

}
