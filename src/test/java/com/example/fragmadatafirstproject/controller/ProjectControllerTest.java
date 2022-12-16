package com.example.fragmadatafirstproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ProjectController.class)
class ProjectControllerTest {

	@MockBean
	ProjectService projectService;

	@Autowired
	MockMvc mockmvc;

	Project project;

	Optional<Project> projct;
	List<Project> pjlist = new ArrayList<>();

	@BeforeEach
	void setup() {
		project = new Project(1, "abc", "xy", "pq", 22, null, null, "qq");
		projct = Optional.of(new Project(1, "abc", "xy", "pq", 22, null, null, "qq"));
		pjlist.add(project);

	}

	@Test
	void testSaveProject() throws JsonProcessingException, Exception {

		when(projectService.saveProject(any())).thenReturn(project);

		mockmvc.perform(post("/saveProject").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(project)).headers(getCommonReqestHeaders()))
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
	void TestgetProjectList() throws Exception {
		when(projectService.getProjectList()).thenReturn(pjlist);

		mockmvc.perform(get("/getProjectList").headers(getCommonReqestHeaders())).andExpect(status().isOk());

	}

	@Test
	void TestgetSingleProjectData() throws Exception {

		when(projectService.getSingleProjectData(1)).thenReturn(projct);

		mockmvc.perform(get("/getSingleProject/{projectId}", "1").headers(getCommonReqestHeaders()))
				.andExpect(status().isOk());

	}
}
