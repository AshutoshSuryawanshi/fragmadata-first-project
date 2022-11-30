package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;
import com.example.fragmadatafirstproject.service.EmployeeService;
//@SpringBootTest
//@WebMvcTest(EmployeeServiceimpl.class)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceimplTest  {
	
@InjectMocks
	private EmployeeServiceimpl er;
	@Mock
	private EmployeeRepository employeeRepository;

	@Autowired private MockMvc mm;	
	
	private Employee emp;
	List<Employee> emplist = new ArrayList<>();
	@BeforeEach
	void setup() {
		emp = new Employee(1,"ab","xy","pq","ad", 110,"pp","Active", "ww", "ee", "rr", "tt",null,"dd");
		emplist.add(emp);
	}
	@Test
	void testGetEmployeeList() {
		String employeeName = "abc";
		Optional<Employee> employee = Optional.of(new Employee(1,"abc","xy","pq","ad", 110,"pp","qq", "ww", "ee", "rr", "tt",null,"dd"));
		Mockito.when(employeeRepository.findById(anyInt())).thenReturn(employee);
		
		Optional<Employee> emp = er.getSingleEmployeeData(1);

		
		assertEquals(employee.get(), emp.get());
		
		verify(employeeRepository, times(1)).findById(anyInt());
	}
	
	@Test
	void testGetEmployeeListByStatus() {
		String status = "Active";
		
		Mockito.when(employeeRepository.findByStatus(status)).thenReturn(emplist);
		
		List<Employee> emp = er.getActiveEmployee();

		
		assertEquals(emplist, emp);
		
		verify(employeeRepository, times(1)).findByStatus(status);
		
	}
	
	
	@Test
	void testgetActiveEmployee(){
		
		List<Employee> emplist= new ArrayList<>();
		Mockito.when(employeeRepository.findAll()).thenReturn(emplist);;
		List<Employee> emp = er.getEmployeeList();
    assertEquals(emplist, emp);
		
		verify(employeeRepository, times(1)).findAll();
	}
	
//	@BeforeEach
//	void setup() {
//	}

	@Test
	public void testSaveProduct() throws Exception {
	Mockito.when(er.saveEmployee(emp)).thenReturn(emp);
	mm.perform(MockMvcRequestBuilders.post("/postEmployee/").contentType(MediaType.APPLICATION_JSON)
	.content("{\r\n" + "\"employeeId\": 4,\r\n"
	 + "\"employeeName\": \"Abc\",\r\n"
	 + "\"designation\": \"hr\",\r\n"
	 + "\"joiningDate\": \"2022-09-09\", \r\n" 
	 + "\"emailId\": \"hr@gmail.com\",\r\n"
	 + "\"mobileNo\": 888888888,\r\n"
	 + "\"gender\": \"male\",\r\n"
	 + "\"status\": \"active\",\r\n"
	 + "\"address\": \"pune\",\r\n"
	 + "\"city\": \"kn\",\r\n"
	 + "\"state\": \"mh\",\r\n"
	 + "\"country\": \"india\",\r\n"
	 + "\"createdDate\": \"2022-09-09\",\r\n"
	 + "\"createdBy\": \"hr\"  \r\n"+"}"))
	.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	
	
//	@Test
//	void shouldsaveEmployeeSuccessfully() {
//	final Employee employee = new Employee(1,"ab","xy","pq","ad", 110,"pp","qq", "ww", "ee", "rr", "tt",null,"dd");
//	given(employeeRepository.findById(employee.getEmployeeId())).willReturn(Optional.empty());
//	given (EmployeeRepository.save(employee)) willAnswer (invocation -> invocation.getArgument(0));
//	Employee savedEmployee = employeeService.createEmployee(Employee);
//	assertThat(savedEmployee).isNotNull();
//	verify (employeeRepository).save (any (Employee.class));
	
	
//
//	@Test
//	void testGetEmployeeList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeltEmployee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateEmployeeData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetSingleEmployeeData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetActiveEmployee() {
//		fail("Not yet implemented");
//	}
	private Object given(Optional<Employee> findById) {
		// TODO Auto-generated method stub
		return null;
	}

	}
