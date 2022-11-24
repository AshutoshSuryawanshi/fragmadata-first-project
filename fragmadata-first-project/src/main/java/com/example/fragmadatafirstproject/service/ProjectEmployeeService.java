package com.example.fragmadatafirstproject.service;

import java.util.List;

import com.example.fragmadatafirstproject.model.ProjectEmployee;

public interface ProjectEmployeeService {

	ProjectEmployee saveProjectEmployee(ProjectEmployee start_date);

	List<ProjectEmployee> getProjectEmployeeList();

	

	


}
