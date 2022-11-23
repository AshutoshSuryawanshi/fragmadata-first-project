package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;
import com.example.fragmadatafirstproject.model.Project;
public interface ProjectService {
	
		
		public Project saveProject(Project project_id);
		
		public List<Project> getProjectList();

		public void deltProject(Integer project_id);

		public Project updateProjectData(Integer project_id, Project p);

		public Optional<Project> getSingleProjectData(int project_id);


	}


