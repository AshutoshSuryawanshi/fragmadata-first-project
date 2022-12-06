package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
class ProjectServiceimplTest {

	@InjectMocks
	ProjectServiceimpl pr;
	@Mock
	ProjectRepository projectRepository;
	Project prjc;
	List<Project> prjlist = new ArrayList<>();

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
		Mockito.when(pr.saveProject(prjc)).thenReturn(prjc);
		Project prj = pr.saveProject(prjc);
		assertEquals(prj, prjc);

	}
}
