package com.example.fragmadatafirstproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
import org.mockito.Mockito;
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
	Project project;
	Employee emp;

	@Autowired
	MockMvc mockmvc;

	ProjectEmployee projectEmployee;

	Optional<ProjectEmployee> projectEmployee2;


	List<ProjectEmployee> emplist = new ArrayList<>();

	@BeforeEach
	void setup() {
		project = new Project(3, "abc", "xy", "pq", 22, null, null, "qq");
		emp = new Employee(2, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");

		projectEmployee = new ProjectEmployee(1, project, emp, null, "amit", null, null, "Active");
		emplist.add(projectEmployee);

		projectEmployee2 = Optional
				.of(new ProjectEmployee(1, project, emp, null, "amit", null, null, "Active"));

	}

	@Test
	void testSaveProjectEmployee() throws JsonProcessingException, Exception {

		when(projectEmployeeService.saveProjectEmployee(any())).thenReturn(projectEmployee);

		mockmvc.perform(post("/saveProjectEmployee").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(projectEmployee)).headers(getCommonReqestHeaders()))
				.andExpect(status().isCreated());
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
		when(projectEmployeeService.updateEndDate(anyInt())).thenReturn(projectEmployee);

		mockmvc.perform(put("/updateEndDate/{projectId}", projectEmployee.getId()).headers(getCommonReqestHeaders()))
				.andExpect(status().isOk());
	}
	@Test
	void TestgetSingleProjectData() throws Exception {

		Mockito.when(projectEmployeeService.getSingleProjectData(anyInt())).thenReturn(projectEmployee2);
		mockmvc.perform(get("/getSingleProjectEmployee/{projectId}", "1").headers(getCommonReqestHeaders()))
				.andExpect(status().isOk());

	}
}
