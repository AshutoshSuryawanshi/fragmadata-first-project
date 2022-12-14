package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
	ProjectServiceimpl er;
	@Mock
	ProjectRepository projectRepository;
	
	Project prjct;
	ProjectDto projectDto;
	List<Project> prjctlist = new ArrayList<>();
	List<ProjectDto> prjctlist1 = new ArrayList<>();
	Optional<Project> prjct1;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	MockMvc mockmvc;
	@BeforeEach
	void setup() {
		
		projectDto = new ProjectDto(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");
		prjct = new Project(1, "abc", "xy", "pq", 22,  LocalDate.now(), LocalDate.now(), "qq");
		prjct1 = Optional
				.of(new Project(1, "abc", "xy", "pq", 22, null, null, "qq"));
		prjctlist.add(prjct);
	}


	@Test
	void testSaveProject() throws Exception  {
		
		
		Project project = new Project(); 
		project.setProjectId(projectDto.getProjectId());
		project.setProjectName(projectDto.getProjectName());
		project.setDescription(projectDto.getDescription());
		project.setClientName(projectDto.getClientName());
		project.setTeamSize(projectDto.getTeamSize());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setStatus(projectDto.getStatus());
		
		Mockito.when(projectRepository.save(project)).thenReturn(project);
		 prjct = er.saveProject(projectDto);
		 System.out.println(prjct);
		assertEquals(projectDto,prjct);
		
	//	verify(projectRepository, times(1)).save(project);
	}
	
	@Test
	void testgetALLProject() {

		List<Project> prjctlist = new ArrayList<>();
		Mockito.when(projectRepository.findAll()).thenReturn(prjctlist);

		List<Project> prjct = er.getProjectList();
		assertEquals(prjctlist,prjct);

		verify(projectRepository, times(1)).findAll();
	}


	@Test
	void testgetSingleProjectData() {
		Optional<Project> p = Optional
				.of(new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq"));
		Mockito.when(projectRepository.findById(anyInt())).thenReturn(p);

		Optional<Project> pro = er.getSingleProjectData(1);

		assertEquals(p.get(), pro.get());

		verify(projectRepository, times(1)).findById(anyInt());
	}


}
