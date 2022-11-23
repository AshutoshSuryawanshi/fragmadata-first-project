package com.example.fragmadatafirstproject.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.service.ProjectService;
import com.example.fragmadatafirstproject.service.ProjectService;

@CrossOrigin("*") 
@RestController 
	public class ProjectController {
	    @Autowired 
	    ProjectService er;
	    

	    @PostMapping(value="/postProject", consumes= {"application/xml", "application/json"}) 
	    public ResponseEntity<Project>saveProject(@RequestBody Project project_id) {
	        System.out.println(project_id);
	        Project Project=er.saveProject(project_id);
	        return new ResponseEntity<Project>(Project, HttpStatus.CREATED);
	    }

	    @GetMapping("/getProjectList") 
	    public ResponseEntity<List<Project>>getProjectList() {
	        List<Project>empList=er.getProjectList();

	        if(empList.isEmpty()) {
	            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Project>>(empList, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteProject/{project_id}") 
	    public ResponseEntity<String>deleteProject(@PathVariable Integer project_id) {
	        er.deltProject(project_id);
	        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	    }

	    @PutMapping(value="/updateProject/{project_id}") 
	    public ResponseEntity<Project>updateProject(@PathVariable Integer project_id, @RequestBody Project e) {
	        Project Proj=er.updateProjectData(project_id, e);
	        return new ResponseEntity<Project>(Proj, HttpStatus.OK);
	    }

	    @GetMapping(value="/getSingleProject/{project_id}") 
	    public ResponseEntity<Optional<Project>>getSingleData(@PathVariable ("project_id") int project_id) {

	        Optional<Project>Proj=er.getSingleProjectData(project_id);
	        return new ResponseEntity<Optional<Project>>(Proj, HttpStatus.OK);
	    }
	}

