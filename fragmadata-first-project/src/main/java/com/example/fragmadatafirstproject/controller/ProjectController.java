package com.example.fragmadatafirstproject.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.dto.ProjectResponce;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.service.ProjectService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@CrossOrigin("*") 
@RestController 
	public class ProjectController {
	private Logger logger=(Logger) GlobalResources.getLogger(EmployeeController.class);
	    @Autowired 
	    ProjectService er;
	    

	    @PostMapping(value="/postProject", consumes= {"application/xml", "application/json"}) 
	    public ResponseEntity<Project>saveProject(@RequestBody Project projectId) {
	    	String methodName="getAllUser()";
	        logger.info(methodName+projectId);
//	        System.out.println(projectId);
	        Project project=er.saveProject(projectId);
	        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	    }

	    @GetMapping("/getProjectList") 
	    public ResponseEntity<ProjectResponce>getProjectList() {
	    	List<Project> projList=er.getProjectList();
	    	ProjectResponce projectResponse=new ProjectResponce();
	    	projectResponse.setEmpList(projList);
	    	projectResponse.setDate(new Date().toString());
	        if(projList.isEmpty()) {
	            return new ResponseEntity<ProjectResponce>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<ProjectResponce>(projectResponse, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteProject/{projectId}") 
	    public ResponseEntity<String>deleteProject(@PathVariable Integer projectId) {
	        er.deleteProject(projectId);
	        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	    }

	    @PutMapping(value="/updateProject/{projectId}") 
	    public ResponseEntity<Project>updateProject(@PathVariable Integer projectId, @RequestBody Project e) {
	        Project Proj=er.updateProjectData(projectId, e);
	        return new ResponseEntity<Project>(Proj, HttpStatus.OK);
	    }

	    @GetMapping(value="/getSingleProject/{projectId}") 
	    public ResponseEntity<Optional<Project>>getSingleData(@PathVariable ("projectId") int projectId) {

	        Optional<Project>Proj=er.getSingleProjectData(projectId);
	        return new ResponseEntity<Optional<Project>>(Proj, HttpStatus.OK);
	    }
	}

