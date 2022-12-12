package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
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

import com.example.fragmadatafirstproject.dto.EmployeeDto;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceimplTest {

	@InjectMocks
	EmployeeServiceimpl er;
	@Mock
	EmployeeRepository employeeRepository;
	 @Mock
     private ObjectMapper modelMapper;
	Employee emp;
	EmployeeDto employeeDto;
	List<Employee> emplist = new ArrayList<>();
	List<EmployeeDto> emplist1 = new ArrayList<>();
	Optional<Employee> emp1;
	@Autowired
	ModelMapper modelMappers;
	
	@BeforeEach
	void setup() {
		 when(modelMapper.readerForMapOf(any())).thenReturn(null);
		 employeeDto = new EmployeeDto(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		emp = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		emp1 = Optional.of(new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd"));
		emplist.add(emp);
		//modelMapper = mock(ModelMapper.class);
	}
	 @Test
     public void testGetByUserId() throws Throwable {
         when(employeeRepository.findById(any())).thenReturn(emp1);

         List<Employee> emplist = er.getEmployeeList();
       

         assertEquals(emplist, emp1.get());
         assertNotNull(emplist);

     }
	

	@Test
	void testGetEmployeeList() {
		Optional<Employee> employee = Optional
				.of(new Employee(1, "abc", "xy", "pq", "ad", 110, "pp", "qq", "ww", "ee", "rr", "tt", null, "dd"));
		Mockito.when(employeeRepository.findById(anyInt())).thenReturn(employee);

		Optional<Employee> emp = er.getSingleEmployeeData(1);

		assertEquals(employee.get(), emp.get());

		verify(employeeRepository, times(1)).findById(anyInt());
	}

	@Test
	void testGetEmployeeListByStatus() {
		String status = "Active";

		Mockito.when(employeeRepository.findByStatus(status)).thenReturn((List<Employee>) employeeDto);

		List<Employee> employeeDto = er.getActiveEmployee();

		assertEquals(emplist1, employeeDto);

		verify(employeeRepository, times(1)).findByStatus(status);

	}

	@Test
	void testgetALLEmployee() {

		List<Employee> emplist = new ArrayList<>();
		Mockito.when(employeeRepository.findAll()).thenReturn(emplist);
		
		List<Employee> emp = er.getEmployeeList();
		assertEquals(emplist, emp);

		verify(employeeRepository, times(1)).findAll();
	}

	@Test
	void testSaveEmployee() throws Exception {
		Employee e =new Employee();
		Mockito.when(er.saveEmployee(employeeDto)).thenReturn(e);
		Employee empl = er.saveEmployee(employeeDto);
		assertEquals(empl, e);

	}
	
}