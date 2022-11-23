package com.example.fragmadatafirstproject.service;

import java.util.List;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project_employee;

public interface Project_employeeService {

	Project_employee saveProject_employee(Project_employee start_date);

	List<Project_employee> getProject_employeeList();

	

	


}
