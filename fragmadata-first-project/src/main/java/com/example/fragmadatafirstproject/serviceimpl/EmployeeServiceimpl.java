package com.example.fragmadatafirstproject.serviceimpl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fragmadatafirstproject.controller.EmployeeController;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.repository.EmployeeRepository;
import com.example.fragmadatafirstproject.service.EmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;


@Service
public class EmployeeServiceimpl implements EmployeeService{
	private Logger logger=(Logger) GlobalResources.getLogger(EmployeeController.class);
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
		String methodName="getAllUser()";
      
		Optional<Employee> op=er.findById(eid);
		if(op.isPresent())
		{
			Employee emp=op.get();
		    		emp.setEmployeeName(em.getEmployeeName());
		    		emp.setDesignation(em.getDesignation());
		    		emp.setJoiningDate(em.getJoiningDate());
		    		emp.setEmailId(em.getEmailId());
		    		emp.setMobileNo(em.getMobileNo());
		    		emp.setGender(em.getGender());
		    		emp.setStatus(em.getStatus());
		    		emp.setAddress(em.getAddress());
		    		emp.setCity(em.getCity());
		    		emp.setState(em.getState());
		    		emp.setCountry(em.getCountry());
		    		emp.setCreatedDate(em.getCreatedDate());
		    		emp.setCreatedBy(em.getCreatedBy());
		    		emp.setGender(em.getGender());
			return er.save(emp);
		}
		else
		{
			  logger.info(methodName+"Employee not available");
//			System.out.println("Employee not available");
			return null;
		}
	}

	@Override
	public Optional<Employee> getSingleEmployeeData(int employee_id) {

		return er.findById(employee_id);
	}

	@Override
	public List<Employee> getActiveEmployee() {
		List<Employee> emps=er.findByStatus("active");
		
//		List<Employee> activeEmployee=emps.stream()
//										  .filter(e->e.getStatus().matches("ACTIVE"))
//										  .collect(Collectors.toList());
		return emps;
	}


}
