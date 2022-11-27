package com.example.fragmadatafirstproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.repository.ProjectEmployeeRepository;
import com.example.fragmadatafirstproject.service.ProjectEmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@CrossOrigin("*")
@RestController
public class ProjectEmployeeController {
	private Logger logger = (Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectEmployeeService er;
	ProjectEmployeeRepository pr;

	@PostMapping(value = "/postProjectEmployee", consumes = { "application/xml", "application/json" })
	public ResponseEntity<ProjectEmployee> saveProjectEmployee(@RequestBody ProjectEmployee projectEmployee) {
		String methodName = "getAllUser()";
		logger.info(methodName + projectEmployee);
		ProjectEmployee ProjectEmployee = er.saveProjectEmployee(projectEmployee);
		er.updateEmployeeData(ProjectEmployee);
		return new ResponseEntity<ProjectEmployee>(ProjectEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/getProjectEmployeeList/")
	public ResponseEntity<List<ProjectEmployee>> getProjectEmployeeList() {
		List<ProjectEmployee> empList = er.getProjectEmployeeList();

		if (empList.isEmpty()) {
			return new ResponseEntity<List<ProjectEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProjectEmployee>>(empList, HttpStatus.OK);

	}

	@GetMapping("/getdata")
	public List<ProjectEmployee> getDataQuery() {
		List<ProjectEmployee> empList = er.getdata();

		return empList;

	}

}
