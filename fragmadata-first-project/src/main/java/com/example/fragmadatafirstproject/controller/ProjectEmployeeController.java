package com.example.fragmadatafirstproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.model.Project;
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
	public ResponseEntity<ProjectEmployee> saveProjectEmployee(@RequestBody ProjectEmployee projectEmp) {
		String methodName = "getAllUser()";
		logger.info(methodName + projectEmp);
		ProjectEmployee projectEmployee = er.saveProjectEmployee(projectEmp);
		er.updateEmployeeData(projectEmployee);
		return new ResponseEntity<ProjectEmployee>(projectEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/getProjectEmployeeList")
	public ResponseEntity<List<ProjectEmployee>> getProjectEmployeeList() {
		List<ProjectEmployee> empList = er.getProjectEmployeeList();

		if (empList.isEmpty()) {
			return new ResponseEntity<List<ProjectEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProjectEmployee>>(empList, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEndDate/{projectId}")
	public ResponseEntity<ProjectEmployee> updateEmployee(@PathVariable Project projectId,
			@RequestBody ProjectEmployee e) {
		ProjectEmployee emp = er.updateEndDate(projectId, e);
		return new ResponseEntity<ProjectEmployee>(emp, HttpStatus.OK);
	}

}
