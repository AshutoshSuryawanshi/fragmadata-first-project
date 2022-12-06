package com.example.fragmadatafirstproject.service;

import java.util.List;
import java.util.Optional;
import com.example.fragmadatafirstproject.model.Project;

public interface ProjectService {

	public Project saveProject(Project projectId);

	public List<Project> getProjectList();

	public Optional<Project> getSingleProjectData(int projectId);

}
