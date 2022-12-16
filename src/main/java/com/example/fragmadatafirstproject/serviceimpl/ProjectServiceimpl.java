package com.example.fragmadatafirstproject.serviceimpl;

import java.time.LocalDate;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.dto.ProjectDto;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;
import com.example.fragmadatafirstproject.service.ProjectService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@Service
public class ProjectServiceimpl implements ProjectService {
	Logger logger = (Logger) GlobalResources.getLogger(ProjectServiceimpl.class);
	@Autowired
	ProjectRepository er;

	@Autowired
	ModelMapper modelMapper;
	@Override
	public Project saveProject(ProjectDto projectDto) {
		Project project = modelMapper.map(projectDto, Project.class);
		LocalDate date = LocalDate.now();
		project.setStartDate(date);
		return er.save(project);
	}

	@Override
	public List<Project> getProjectList() {
		return er.findAll();
	}

	@Override
	public Optional<Project> getSingleProjectData(int projectId) {

		return er.findById(projectId);
	}

}
