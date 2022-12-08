package com.example.fragmadatafirstproject.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.ProjectRepository;
import com.example.fragmadatafirstproject.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProjectController.class)
@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	ProjectService projectService;
	
	@Mock
	ProjectRepository projectRepository;
	Project project;
	List<Project> ProjectList = new ArrayList<>();

	@BeforeEach
	void setup() {
		project = new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");
		ProjectList.add(project);
	}
	

	@Test
	void testSaveProject() throws Exception {
		project = new Project(1, "abc", "xy", "pq", 22, LocalDate.now(), LocalDate.now(), "qq");
		
		String inputInJson = this.mapToJson(project);
		
		String URI = "/postProject";
		
		Mockito.when(projectService.saveProject(project)).thenReturn(project);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}


	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
