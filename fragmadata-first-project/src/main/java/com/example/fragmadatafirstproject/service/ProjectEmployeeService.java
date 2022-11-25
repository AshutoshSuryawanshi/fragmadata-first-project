package com.example.fragmadatafirstproject.service;

import java.util.List;

import com.example.fragmadatafirstproject.dto.ProjectEmployeeResponce;
import com.example.fragmadatafirstproject.model.ProjectEmployee;

@SuppressWarnings("unused")
public interface ProjectEmployeeService {

	public ProjectEmployee saveProjectEmployee(ProjectEmployee startDate);

	public List<ProjectEmployee> getProjectEmployeeList();

	public List<ProjectEmployee> getProjectEmployeeOnStartDate(String startDate);
	

	


}
