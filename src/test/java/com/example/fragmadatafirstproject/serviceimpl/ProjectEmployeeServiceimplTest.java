package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
	
	ProjectDto prjdto;
	EmployeeDto empdto;
	ProjectEmployeeDto pempdto;
	
	Project p;
	Employee emp;
	ProjectEmployee pemp;
	List<ProjectEmployee> emplist = new ArrayList<>();
	Optional<ProjectEmployee> pempop;

	@BeforeEach
	void setup() {
		p = new Project(1, "abc", "xy", "pq", 22, null, null, "qq");
		emp = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		pemp = new ProjectEmployee(1, p, emp, null, "amit", null, null, "Active");
		pempdto =  new ProjectEmployeeDto(1, p, emp, null, "amit", null, null, "Active");
		emplist.add(pemp);

	}

	@Test
	void testSaveProjectEmployee() throws Exception {

		Mockito.when(projectEmployeeRepository.save(any())).thenReturn(pemp);
		
		when(modelMapper.map(any(), any())).thenReturn(pemp);
		ProjectEmployee saveprojectEmployee = projectEmployeeService.saveProjectEmployee(pempdto);
	
		assertEquals(saveprojectEmployee, pemp);

		verify(projectEmployeeRepository,times(1)).save(any());

	}

	@Test
	void updateEndDateTest() {

		Mockito.when(projectEmployeeRepository.findById(pemp.getId())).thenReturn(java.util.Optional.ofNullable(pemp));
		
		Mockito.when(projectEmployeeService.updateEndDate(pemp.getId())).thenReturn(pemp);
	
		ProjectEmployee updateprojectEmployee = projectEmployeeService.updateEndDate(pemp.getId());

		assertEquals(updateprojectEmployee.getEndDate(), LocalDate.now());

	}
	
}
