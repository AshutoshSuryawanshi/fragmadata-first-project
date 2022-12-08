package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.repository.ProjectEmployeeRepository;

@ExtendWith(MockitoExtension.class)
class ProjectEmployeeServiceimplTest {
	@InjectMocks
	private ProjectEmployeeServiceimpl pe;

	@Mock
	ProjectEmployeeRepository projectEmployeeRepository;
	Project p;
	Employee emp;
	ProjectEmployee pemp;
	List<ProjectEmployee> emplist = new ArrayList<>();

	@BeforeEach
	void setup() {
		p = new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");
		emp = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");

		pemp = new ProjectEmployee(1, p, emp, LocalDate.now(), "amit", LocalDate.now(), LocalDate.now(), "Active");
		emplist.add(pemp);
	}

	@Test
	void testSaveProjectEmployee() throws Exception {
		Mockito.when(pe.saveProjectEmployee(pemp)).thenReturn(pemp);
		ProjectEmployee prj = pe.saveProjectEmployee(pemp);
		assertEquals(prj, pemp);

	}

//	@Test
//	void updateEndDateTest() {
//		Mockito.when(pe.updateEmployeeData(pemp.getEmployeeId().getEmployeeId())).thenReturn(pemp);
//		ProjectEmployee prj = pe.updateEmployeeData(pemp.getEmployeeId().getEmployeeId());
//		assertEquals(prj, pemp);
//
//	}

}
