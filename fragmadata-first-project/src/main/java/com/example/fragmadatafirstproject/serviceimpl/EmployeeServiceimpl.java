package com.example.fragmadatafirstproject.serviceimpl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;
import com.example.fragmadatafirstproject.service.EmployeeService;


@Service
public class EmployeeServiceimpl implements EmployeeService{
	@Autowired
	EmployeeRepository er;

	@Override
	public Employee saveEmployee(Employee id) {
		
		return er.save(id);
	}

	@Override
	public List<Employee> getEmployeeList() {
		
		return er.findAll();
		}

	@Override
	public void deltEmployee(Integer lid) {
		er.deleteById(lid);
	}

	@Override
	public Employee updateEmployeeData(Integer eid, Employee em) {
		Optional<Employee> op=er.findById(eid);
		if(op.isPresent())
		{
			Employee emp=op.get();
		    		emp.setEmployee_name(em.getEmployee_name());
		    		emp.setDesignation(em.getDesignation());
		    		emp.setJoining_date(em.getJoining_date());
		    		emp.setEmail_id(em.getEmail_id());
		    		emp.setMobile_no(em.getMobile_no());
		    		emp.setGender(em.getGender());
		    		emp.setStatus(em.getStatus());
		    		emp.setAddress(em.getAddress());
		    		emp.setCity(em.getCity());
		    		emp.setState(em.getState());
		    		emp.setCountry(em.getCountry());
		    		emp.setCreated_date(em.getCreated_date());
		    		emp.setCreated_by(em.getCreated_by());
		    		emp.setGender(em.getGender());
			return er.save(emp);
		}
		else
		{
			System.out.println("Employee not available");
			return null;
		}
	}

	@Override
	public Optional<Employee> getSingleEmployeeData(int employee_id) {

		return er.findById(employee_id);
	}

	@Override
	public List<Employee> getActiveEmployee() {
		List<Employee> emps=er.findAll();
		
		List<Employee> activeEmployee=emps.stream()
										  .filter(e->e.getStatus().matches("ACTIVE"))
										  .collect(Collectors.toList());
		return activeEmployee;
	}


}
