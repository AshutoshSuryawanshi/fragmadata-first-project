package com.example.fragmadatafirstproject.serviceimpl;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;
import com.example.fragmadatafirstproject.repository.ProjectRepository;
import com.example.fragmadatafirstproject.service.EmployeeService;
import com.example.fragmadatafirstproject.service.ProjectService;

@Service
public class ProjectServiceimpl implements ProjectService {
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
			Optional<Project> op=er.findById(project_id);
			if(op.isPresent())
			{
				Project emp=op.get();
			    		emp.setProject_name(em.getProject_name());
			    		emp.setDescription(em.getDescription());
			    		emp.setClient_name(em.getClient_name());
			    		emp.setStart_date(em.getStart_date());
			    		emp.setEnd_date(em.getEnd_date());
			    		emp.setTeam_size(em.getTeam_size());
			    		emp.setStatus(em.getStatus());
			    		
				return er.save(emp);
			}
			else
			{
				System.out.println("Project not available");
				return null;
			}
		}

		@Override
		public Optional<Project> getSingleProjectData(int project_id) {

			return er.findById(project_id);
		}
		


	}

