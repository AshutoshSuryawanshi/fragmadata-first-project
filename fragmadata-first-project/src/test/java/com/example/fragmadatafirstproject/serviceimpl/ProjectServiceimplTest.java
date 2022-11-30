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

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;


@ExtendWith(MockitoExtension.class)
class ProjectServiceimplTest {

	
@InjectMocks
	private ProjectServiceimpl pr;
	@Mock
	private ProjectRepository projectRepository;
	
	@BeforeEach
	void setup() {
		
	}
	
	@Test
	void testGetEmployeeList() {
		Optional<Project> p = Optional.of(new Project(1,"abc","xy","pq",22, LocalDate.now(),LocalDate.now(),"qq"));
		Mockito.when(projectRepository.findById(anyInt())).thenReturn(p);
		
		Optional<Project> pro = pr.getSingleProjectData(1);

		
		assertEquals(p.get(), pro.get());
		
		verify(projectRepository, times(1)).findById(anyInt());
	}
	
	
	@Test
	void testgetActiveEmployee(){
		
		List<Project> prlist= new ArrayList<>();
		Mockito.when(projectRepository.findAll()).thenReturn(prlist);;
		List<Project> pl = pr.getProjectList();
    assertEquals(prlist, pl);
		
		verify(projectRepository, times(1)).findAll();
	}
	
	
}
