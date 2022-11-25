package com.example.fragmadatafirstproject.serviceimpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;
import com.example.fragmadatafirstproject.service.ProjectService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@Service
public class ProjectServiceimpl implements ProjectService {
	private Logger logger=(Logger) GlobalResources.getLogger(EmployeeController.class);
	@Autowired
	ProjectRepository er;
     @Override
		public Project saveProject(Project projectId) {
			
			return er.save(projectId);
		}

		@Override
		public List<Project> getProjectList() {
			
			return er.findAll();
			}

		@Override
		public void deleteProject(Integer projectId) {
			er.deleteById(projectId);
		}

		@Override
		public Project updateProjectData(Integer projectId, Project p) {
			String methodName="getAllUser()";
	        
			Optional<Project> op=er.findById(projectId);
			if(op.isPresent())
			{
				Project emp=op.get();
			    		emp.setProjectName(p.getProjectName());
			    		emp.setDescription(p.getDescription());
			    		emp.setClientName(p.getClientName());
			    		emp.setStartDate(p.getStartDate());
			    		emp.setEndDate(p.getEndDate());
			    		emp.setTeamSize(p.getTeamSize());
			    		emp.setStatus(p.getStatus());
			    		
				return er.save(emp);
			}
			else
			{
				logger.info(methodName+"Project not available");
				System.out.println("Project not available");
				return null;
			}
		}

		@Override
		public Optional<Project> getSingleProjectData(int projectId) {

			return er.findById(projectId);
		}
		


	}

