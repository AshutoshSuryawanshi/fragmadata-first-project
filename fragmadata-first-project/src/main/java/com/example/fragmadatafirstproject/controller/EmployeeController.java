package com.example.fragmadatafirstproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.dto.EmployeeResponce;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/postEmployee", consumes = { "application/xml", "application/json" })
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emps) {
		return new ResponseEntity<>(employeeService.saveEmployee(emps), HttpStatus.CREATED);
	}

	@GetMapping("/getEmployeeList")
	public ResponseEntity<EmployeeResponce> getEmployeeList() {
		List<Employee> empList = employeeService.getEmployeeList();
		EmployeeResponce employeeResponse = new EmployeeResponce();
		employeeResponse.setEmpList(empList);
		employeeResponse.setDate(LocalDate.now());
		if (empList.isEmpty()) {
			return null;
		}
		return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/getSingleEmployee/{eid}")
	public ResponseEntity<Optional<Employee>> getSingleData(@PathVariable("eid") int eid) {

		Optional<Employee> emp = employeeService.getSingleEmployeeData(eid);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping(value = "/getActiveEmployee")
	public ResponseEntity<List<Employee>> getActiveEmployee() {
		List<Employee> empList = employeeService.getActiveEmployee();

		if (empList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empList, HttpStatus.OK);

	}
}