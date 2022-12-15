package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.fragmadatafirstproject.dto.ProjectDto;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
class ProjectServiceimplTest {

	@InjectMocks
	ProjectServiceimpl projectService;

	@Mock
	ProjectRepository projectRepository;

	@Mock
	ModelMapper modelMapper;

	@Autowired
	MockMvc mockmvc;

	Project project;
	ProjectDto projectDto;
	Optional<Project> opProject;

	@BeforeEach
	void setup() {

		projectDto = new ProjectDto(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");

		project = new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");

		opProject = Optional.of(new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq"));
	}

	@Test
	void testSaveProject() throws Exception {

		Mockito.when(projectRepository.save(any())).thenReturn(project);
		when(modelMapper.map(any(), any())).thenReturn(project);
		Project saveProject = projectService.saveProject(projectDto);
		//Project saveProject = projectRepository.save(project);

		assertEquals(saveProject, project);

		verify(projectRepository,times(1)).save(any());

	}

	@Test
	void testgetALLProject() {

		List<Project> prjctlist = new ArrayList<>();

		Mockito.when(projectRepository.findAll()).thenReturn(prjctlist);

		List<Project> prjct = projectService.getProjectList();

		assertEquals(prjctlist, prjct);

		verify(projectRepository, times(1)).findAll();
	}

	@Test
	void testgetSingleProjectData() {

		Mockito.when(projectRepository.findById(anyInt())).thenReturn(opProject);

		Optional<Project> pro = projectService.getSingleProjectData(1);
		
		assertEquals(opProject.get(), pro.get());

		verify(projectRepository, times(1)).findById(anyInt());
	}

}
