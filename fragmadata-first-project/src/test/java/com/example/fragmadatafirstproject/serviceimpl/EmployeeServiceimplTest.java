package com.example.fragmadatafirstproject.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.fragmadatafirstproject.dto.EmployeeDto;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceimplTest {

	@InjectMocks
	EmployeeServiceimpl er;
	@Mock
	EmployeeRepository employeeRepository;
	@Mock
//	private ObjectMapper modelMapper;
	Employee emp;
	EmployeeDto employeeDto;
	List<Employee> emplist = new ArrayList<>();
	List<EmployeeDto> emplist1 = new ArrayList<>();
	Optional<Employee> emp1;
	@Autowired
	ModelMapper modelMapper;

	@BeforeEach
	void setup() {
		modelMapper = mock(ModelMapper.class);
		employeeDto = new EmployeeDto(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null,
				"dd");
		emp = new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd");
		emp1 = Optional
				.of(new Employee(1, "ab", "xy", "pq", "ad", 110, "pp", "Active", "ww", "ee", "rr", "tt", null, "dd"));

		// EmployeeDto employeeDto = modelMapper.map(emp, EmployeeDto.class);
		
		emplist.add(emp);
	
	}

	@Test
	void testGetSingleEmployeeData() {
		Mockito.when(employeeRepository.findById(anyInt())).thenReturn(emp1);

		Employee empl = er.getSingleEmployeeData(1);

		assertEquals(empl,emp1.get());

		verify(employeeRepository, times(1)).findById(anyInt());
	}

	@Test
	void testGetEmployeeListByStatus() {
		String status = "Active";

		Mockito.when(employeeRepository.findByStatus("Active")).thenReturn(emplist);

		List<Employee> emp = er.getActiveEmployee();

		assertEquals(emp,emplist);

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

//	@Test
//	void testSaveEmployee() throws Exception {
//		//Employee e = new Employee();
//		when(er.saveEmployee(any())).thenReturn(emp);
//		when(emp.getEmployeeId()).thenReturn(1);
//	//	Mockito.when(er.saveEmployee(employeeDto)).thenReturn(emp);
//		 emp = er.saveEmployee(employeeDto);
//		assertEquals(emp.getEmployeeId(),emp.getEmployeeId());
//
//	}

}