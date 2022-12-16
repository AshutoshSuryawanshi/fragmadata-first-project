package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceimplTest {

	@InjectMocks
	EmployeeServiceimpl employeeServiceimpl;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Mock
	ModelMapper modelMapper;
	
	@Autowired
	MockMvc mockmvc;
	
	Employee employee;
	EmployeeDto employeeDto;
	List<Employee> emplist = new ArrayList<>();
	List<EmployeeDto> emplist1 = new ArrayList<>();
	Optional<Employee> emp1;


	@BeforeEach
	void setup() {
	
		employeeDto = new EmployeeDto(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null,
				"dd");
		employee = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		emp1 = Optional
				.of(new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd"));

	
		
		emplist.add(employee);
	
	}

	@Test
	void testGetSingleEmployeeData() {
		Mockito.when(employeeRepository.findById(anyInt())).thenReturn(emp1);

		Employee empl = employeeServiceimpl.getSingleEmployeeData(1);

		assertEquals(empl,emp1.get());

		verify(employeeRepository, times(1)).findById(anyInt());
	}

	@Test
	void testGetEmployeeListByStatus() {
		String status = "Active";

		Mockito.when(employeeRepository.findByStatus("Active")).thenReturn(emplist);

		List<Employee> employee = employeeServiceimpl.getActiveEmployee();

		assertEquals(employee,emplist);

		verify(employeeRepository, times(1)).findByStatus(status);

	}

	@Test
	void testgetALLEmployee() {

		List<Employee> emplist = new ArrayList<>();
		Mockito.when(employeeRepository.findAll()).thenReturn(emplist);

		List<Employee> employee = employeeServiceimpl.getEmployeeList();
		assertEquals(emplist, employee);

		verify(employeeRepository, times(1)).findAll();
	}
	@Test
	void testSaveEmployee() throws Exception {

		Mockito.when(employeeRepository.save(any())).thenReturn(employee);
		
		when(modelMapper.map(any(), any())).thenReturn(employee);
		Employee saveEmployee = employeeServiceimpl.saveEmployee(employeeDto);
	
		assertEquals(saveEmployee, employee);

		verify(employeeRepository,times(1)).save(any());

	}

}