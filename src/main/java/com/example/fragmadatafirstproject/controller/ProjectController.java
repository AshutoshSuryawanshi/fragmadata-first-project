package com.example.fragmadatafirstproject.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.dto.ProjectDto;
import com.example.fragmadatafirstproject.dto.ProjectResponce;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.service.ProjectService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@RestController
public class ProjectController {
	Logger logger = (Logger) GlobalResources.getLogger(ProjectController.class);
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ModelMapper modelMapper;

	@CrossOrigin
	@PostMapping(value = "/saveProject", consumes = { "application/xml", "application/json" })
	public ResponseEntity<Project> saveProject(@RequestBody ProjectDto projectDto) {
		return new ResponseEntity<>(projectService.saveProject(projectDto), HttpStatus.CREATED);
	}

	@GetMapping("/getProjectList")
	public ResponseEntity<ProjectResponce> getProjectList() {
		List<Project> projList = projectService.getProjectList();
		ProjectResponce projectResponse = new ProjectResponce();
		projectResponse.setEmpList(projList);
		projectResponse.setDate(new Date().toString());
		if (projList.isEmpty()) {
			return null;
		}
		return new ResponseEntity<>(projectResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/getSingleProject/{projectId}")
	public ResponseEntity<Optional<Project>> getSingleData(@PathVariable("projectId") int projectId) {

		Optional<Project> proj = projectService.getSingleProjectData(projectId);
		return new ResponseEntity<>(proj, HttpStatus.OK);
	}
}
