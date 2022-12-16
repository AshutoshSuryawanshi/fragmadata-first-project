package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.fragmadatafirstproject.dto.EmployeeDto;
import com.example.fragmadatafirstproject.dto.ProjectDto;
import com.example.fragmadatafirstproject.dto.ProjectEmployeeDto;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.repository.ProjectEmployeeRepository;

@ExtendWith(MockitoExtension.class)
class ProjectEmployeeServiceimplTest {
	
	@InjectMocks
	ProjectEmployeeServiceimpl projectEmployeeService;

	@Mock
	ModelMapper modelMapper;
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	ProjectEmployeeRepository projectEmployeeRepository;
	
	ProjectDto projectDto;
	EmployeeDto employeeDto;
	ProjectEmployeeDto projectEmployeeDto;
	
	Project project;
	Employee employee;
	ProjectEmployee projectEmployee;
	List<ProjectEmployee> emplist = new ArrayList<>();
Optional<ProjectEmployee>projectEmployeeoptional;

	@BeforeEach
	void setup() {
		project = new Project(1, "abc", "xy", "pq", 22, null, null, "qq");
		employee = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		projectEmployee = new ProjectEmployee(1, project, employee, null, "amit", null, null, "Active");
		projectEmployeeDto =  new ProjectEmployeeDto(1, project, employee, null, "amit", null, null, "Active");
		emplist.add(projectEmployee);
		projectEmployeeoptional = Optional
				.of(new ProjectEmployee(1, project, employee, null, "amit", null, null, "Active"));

	}

	@Test
	void testSaveProjectEmployee() throws Exception {

		Mockito.when(projectEmployeeRepository.save(any())).thenReturn(projectEmployee);
		
		when(modelMapper.map(any(), any())).thenReturn(projectEmployee);
		ProjectEmployee saveprojectEmployee = projectEmployeeService.saveProjectEmployee(projectEmployeeDto);
	
		assertEquals(saveprojectEmployee, projectEmployee);

		verify(projectEmployeeRepository,times(1)).save(any());

	}

	@Test
	void updateEndDateTest() {

		Mockito.when(projectEmployeeRepository.findById(projectEmployee.getId())).thenReturn(java.util.Optional.ofNullable(projectEmployee));
		
		Mockito.when(projectEmployeeService.updateEndDate(projectEmployee.getId())).thenReturn(projectEmployee);
	
		ProjectEmployee updateprojectEmployee = projectEmployeeService.updateEndDate(projectEmployee.getId());

		assertEquals(updateprojectEmployee.getEndDate(), LocalDate.now());

	}
	@Test
	void testgetProjectEmployeeList() {

		List<ProjectEmployee> emplist = new ArrayList<>();
		Mockito.when(projectEmployeeRepository.findAll()).thenReturn(emplist);

		List<ProjectEmployee> projectEmployee = projectEmployeeService.getProjectEmployeeList();
		assertEquals(emplist, projectEmployee);

		verify(projectEmployeeRepository, times(1)).findAll();
	}
	@Test
	void testgetSingleProjectData() {
		Mockito.when(projectEmployeeRepository.findById(anyInt())).thenReturn(projectEmployeeoptional);

		Optional<ProjectEmployee> projectEmployee = projectEmployeeService.getSingleProjectData(1);

		assertEquals(projectEmployee.get(),projectEmployeeoptional.get());

		verify(projectEmployeeRepository, times(1)).findById(anyInt());
	}
}
