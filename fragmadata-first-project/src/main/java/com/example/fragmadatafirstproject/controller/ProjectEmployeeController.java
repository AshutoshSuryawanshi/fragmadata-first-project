package com.example.fragmadatafirstproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.repository.ProjectEmployeeRepository;
import com.example.fragmadatafirstproject.service.ProjectEmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@RestController
public class ProjectEmployeeController {
	Logger logger = (Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectEmployeeService er;
	ProjectEmployeeRepository pr;

	@PostMapping(value = "/postProjectEmployee", consumes = { "application/xml", "application/json" })
	public ResponseEntity<ProjectEmployee> saveProjectEmployee(@RequestBody ProjectEmployee projemp) {

		ProjectEmployee projEmployee = er.saveProjectEmployee(projemp);
		er.updateEmployeeData(projEmployee);
		return new ResponseEntity<>(projEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/getProjectEmployeeList")
	public ResponseEntity<List<ProjectEmployee>> getProjectEmployeeList() {
		List<ProjectEmployee> empList = er.getProjectEmployeeList();

		if (empList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	
	@PutMapping(value = "/updateEndDate/{projectId}")
	public ResponseEntity<Optional<ProjectEmployee>> updateEmployee(@PathVariable("projectId") int projectId) {
		
		return new ResponseEntity<>(er.updateEndDate(projectId), HttpStatus.OK);
		
	}

}
