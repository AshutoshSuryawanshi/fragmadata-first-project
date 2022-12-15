package com.example.fragmadatafirstproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.example.fragmadatafirstproject.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

	@MockBean
	EmployeeService employeeService;

	@Autowired
	MockMvc mockmvc;

	Employee employee;

	Optional<Employee> emp;
	List<Employee> emplist = new ArrayList<>();

	@BeforeEach
	void setup() {
		employee = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		emp = Optional
				.of(new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd"));
		emplist.add(employee);

	}

	@Test
	void testSaveEmployee() throws JsonProcessingException, Exception {

		when(employeeService.saveEmployee(any())).thenReturn(employee);
		mockmvc.perform(post("/postEmployee").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(employee)).headers(getCommonReqestHeaders()))
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
	void TestgetAllEmployee() throws Exception {
		when(employeeService.getEmployeeList()).thenReturn(emplist);

		mockmvc.perform(get("/getEmployeeList").headers(getCommonReqestHeaders())).andExpect(status().isOk());

	}

	@Test
	void TestgetSingleEmployee() throws Exception {

//		when(employeeService.getSingleEmployeeData(1)).thenReturn(emp.get());
		Mockito.when(employeeService.getSingleEmployeeData(anyInt())).thenReturn(employee);
		mockmvc.perform(get("/getSingleEmployee/{eid}", "1").headers(getCommonReqestHeaders()))
				.andExpect(status().isOk());

	}

	@Test
	void TestgetActiveEmployee() throws Exception {

		when(employeeService.getActiveEmployee()).thenReturn(emplist);

		mockmvc.perform(get("/getActiveEmployee").headers(getCommonReqestHeaders())).andExpect(status().isOk());

	}

}