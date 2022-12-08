package com.example.fragmadatafirstproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.model.ProjectEmployee;
import com.example.fragmadatafirstproject.service.ProjectEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ProjectEmployeeController.class)
class ProjectEmployeeControllerTest {

	@MockBean
	ProjectEmployeeService projectEmployeeService;
	Project p;
	Employee emp;

	@Autowired
	MockMvc mockmvc;

	ProjectEmployee projectEmployee;

	Optional<ProjectEmployee> projectEmployee2;
	
	Optional<ProjectEmployee> pemp;
	List<ProjectEmployee> emplist = new ArrayList<>();

	@BeforeEach
	void setup() {
		p = new Project(3, "abc", "xy", "pq", 22, null, null, "qq");
		emp = new Employee(2, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");

		projectEmployee = new ProjectEmployee(1, p, emp, null, "amit", null, null, "Active");
		emplist.add(projectEmployee);

	}

	@Test
	void testSaveProjectEmployee() throws JsonProcessingException, Exception {

		when(projectEmployeeService.saveProjectEmployee(any())).thenReturn(projectEmployee);

		mockmvc.perform(post("/postProjectEmployee").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(projectEmployee)).headers(getCommonReqestHeaders()))
				.andExpect(status().isCreated());
		;
	}

	private HttpHeaders getCommonReqestHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-CORRELATION-ID", "123");
		httpHeaders.add("SOURCE-ID", "123");
		httpHeaders.add("X-AUTH-ID", "");
		httpHeaders.add("X-AUTH-TOKEN", "");
		httpHeaders.add("LOGGED-IN-USER-ROLE", "");
		httpHeaders.add("userId", "");
		httpHeaders.add("role", "RM");

		return httpHeaders;
	}

	@Test
	void TestgetProjectEmployeeList() throws Exception {
		when(projectEmployeeService.getProjectEmployeeList()).thenReturn(emplist);

		mockmvc.perform(get("/getProjectEmployeeList").headers(getCommonReqestHeaders())).andExpect(status().isOk());

	}

	@Test
	void TestgetupdateEndDate() throws Exception {
		when(projectEmployeeService.updateEndDate(projectEmployee2)).thenReturn(projectEmployee);

		mockmvc.perform(put("/updateEndDate/{projectId}", 2).headers(getCommonReqestHeaders()))
				.andExpect(status().isOk());

	}
}
