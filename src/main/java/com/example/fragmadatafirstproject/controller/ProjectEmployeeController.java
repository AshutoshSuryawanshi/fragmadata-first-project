package com.example.fragmadatafirstproject.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fragmadatafirstproject.dto.ProjectEmployeeDto;
import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.service.ProjectEmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@RestController
public class ProjectEmployeeController {
	Logger logger = (Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectEmployeeService er;
	
	@Autowired
	ModelMapper modelMapper;
	
	@CrossOrigin
	@PostMapping(value = "/saveProjectEmployee", consumes = { "application/xml", "application/json" })
	public ResponseEntity<ProjectEmployee> saveProjectEmployee(@RequestBody ProjectEmployeeDto projectEmployeeDto) {
		return new ResponseEntity<>(er.saveProjectEmployee(projectEmployeeDto), HttpStatus.CREATED);
	}

	@GetMapping("/getProjectEmployeeList")
	public ResponseEntity<List<ProjectEmployee>> getProjectEmployeeList() {
		List<ProjectEmployee> empList = er.getProjectEmployeeList();

		if (empList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSingleProjectEmployee/{projectId}")
	public ResponseEntity<Optional<ProjectEmployee>> getSingleData(@PathVariable("projectId") int projectId) {

		Optional<ProjectEmployee> emp = er.getSingleProjectData(projectId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEndDate/{projectId}")
	public ResponseEntity<ProjectEmployee> updateEndDate(@PathVariable("projectId")int  projectId) {
		return new ResponseEntity<>(er.updateEndDate(projectId), HttpStatus.OK);
	}


}
