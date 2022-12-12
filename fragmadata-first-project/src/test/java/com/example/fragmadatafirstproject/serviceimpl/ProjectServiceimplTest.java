package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.fragmadatafirstproject.dto.ProjectDto;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;


class ProjectServiceimplTest {

	@InjectMocks
	ProjectServiceimpl pr;
	@Mock
	ProjectRepository projectRepository;
	Project prjc;
	
	ProjectDto projectDto;
	List<Project> prjlist;
	
	@BeforeEach
	void setup() {
		prjc = new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");
		prjlist.add(prjc);
	}

	@Test
	void testgetSingleProjectData() {
		Optional<Project> p = Optional
				.of(new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq"));
		Mockito.when(projectRepository.findById(anyInt())).thenReturn(p);

		Optional<Project> pro = pr.getSingleProjectData(1);

		assertEquals(p.get(), pro.get());

		verify(projectRepository, times(1)).findById(anyInt());
	}

	@Test
	void testgetProjectList() {

		List<Project> prlist = new ArrayList<>();
		Mockito.when(projectRepository.findAll()).thenReturn(prlist);
		List<Project> pl = pr.getProjectList();
		assertEquals(prlist, pl);

		verify(projectRepository, times(1)).findAll();
	}

	@Test
	void testSaveProject() throws Exception {
		Mockito.when(pr.saveProject(projectDto)).thenReturn(prjc);
		Project prj = pr.saveProject(projectDto);
		assertEquals(prj, prjc);

	}

}
