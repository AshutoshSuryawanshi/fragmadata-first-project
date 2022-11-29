package com.example.fragmadatafirstproject.service;

import java.util.List;

import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.model.ProjectEmployee;

public interface ProjectEmployeeService {

	public ProjectEmployee saveProjectEmployee(ProjectEmployee startDate);

	public List<ProjectEmployee> getProjectEmployeeList();

	public ProjectEmployee updateEmployeeData(ProjectEmployee em);

	public ProjectEmployee updateEndDate(Project pid, ProjectEmployee pe);

}
