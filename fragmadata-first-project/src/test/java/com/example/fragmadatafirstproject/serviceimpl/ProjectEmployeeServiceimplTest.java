package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
	private ProjectEmployeeServiceimpl pe;

	@Autowired
	ModelMapper modelMapper;
	
	@Mock
	ProjectEmployeeRepository projectEmployeeRepository;
	ProjectDto prjdto;
	EmployeeDto empdto;
	ProjectEmployeeDto pempdto;
	
	Project p;
	Employee emp;
	ProjectEmployee pemp;
	List<ProjectEmployee> emplist = new ArrayList<>();
	Optional<ProjectEmployee> emp1;

	@BeforeEach
	void setup() {
		p = new Project(1, "abc", "xy", "pq", 22, null, null, "qq");
		emp = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		emp1 = Optional.of(new ProjectEmployee(1, p, emp, null, "amit", null, null, "Active"));
		pemp = new ProjectEmployee(1, p, emp, null, "amit", null, null, "Active");
		
		 prjdto= modelMapper.map(p, ProjectDto.class);
		 empdto= modelMapper.map(emp, EmployeeDto.class);
		 pempdto= modelMapper.map(pemp, ProjectEmployeeDto.class);
		emplist.add(pemp);

	}

	@Test
	void testSaveProjectEmployee() throws Exception {
		
		Mockito.when(pe.saveProjectEmployee(pempdto)).thenReturn(pemp);
		ProjectEmployee prj = pe.saveProjectEmployee(pempdto);
		assertEquals(prj, pemp);

	}
//
//	@Test
//	void updateEndDateTest() {
//		Mockito.when(projectEmployeeRepository.findById(anyInt())).thenReturn(emp1);
//		ProjectEmployee prj = pe.updateEndDate(emp1.get());
//		assertEquals(emp1.get(),prj.getEndDate());

}
