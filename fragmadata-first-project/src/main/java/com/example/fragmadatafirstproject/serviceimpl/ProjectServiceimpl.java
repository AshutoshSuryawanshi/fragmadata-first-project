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
		public Project saveProject(Project project_id) {
			
			return er.save(project_id);
		}

		@Override
		public List<Project> getProjectList() {
			
			return er.findAll();
			}

		@Override
		public void deltProject(Integer project_id) {
			er.deleteById(project_id);
		}

		@Override
		public Project updateProjectData(Integer project_id, Project em) {
			String methodName="getAllUser()";
	        
			Optional<Project> op=er.findById(project_id);
			if(op.isPresent())
			{
				Project emp=op.get();
			    		emp.setProjectName(em.getProjectName());
			    		emp.setDescription(em.getDescription());
			    		emp.setClientName(em.getClientName());
			    		emp.setStartDate(em.getStartDate());
			    		emp.setEndDate(em.getEndDate());
			    		emp.setTeamSize(em.getTeamSize());
			    		emp.setStatus(em.getStatus());
			    		
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
		public Optional<Project> getSingleProjectData(int project_id) {

			return er.findById(project_id);
		}
		


	}

