package com.example.fragmadatafirstproject.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.dto.EmployeeResponce;
import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.service.EmployeeService;

import ch.qos.logback.classic.Logger;
import utility.GlobalResources;

@CrossOrigin("*") 
@RestController 
public class EmployeeController {
	
	private Logger logger=(Logger) GlobalResources.getLogger(EmployeeController.class);
    @Autowired 
    EmployeeService er;
    

    @PostMapping(value="/postEmployee", consumes= {"application/xml", "application/json"})
    
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employeeId) {
    	String methodName="getAllUser()";
        logger.info(methodName+employeeId);
//        System.out.println(employeeId);
        Employee Employee=er.saveEmployee(employeeId);
        return new ResponseEntity<Employee>(Employee, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeList") 
    public ResponseEntity<EmployeeResponce> getEmployeeList() {
        List<Employee> empList=er.getEmployeeList();
        EmployeeResponce employeeResponse=new EmployeeResponce();
        employeeResponse.setEmpList(empList);
        employeeResponse.setDate(new Date().toString());
        if(empList.isEmpty()) {
            return new ResponseEntity<EmployeeResponce>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<EmployeeResponce>(employeeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{eid}") 
    public ResponseEntity<String>deleteEmployee(@PathVariable Integer eid) {
        er.deltEmployee(eid);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/updateEmployee/{eid}") 
    public ResponseEntity<Employee>updateEmployee(@PathVariable Integer eid, @RequestBody Employee e) {
        Employee emp=er.updateEmployeeData(eid, e);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @GetMapping(value="/getSingleEmployee/{eid}") 
    public ResponseEntity<Optional<Employee>>getSingleData(@PathVariable ("eid") int eid) {

        Optional<Employee>emp=er.getSingleEmployeeData(eid);
        return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
    }
    
    @GetMapping(value="/getActiveEmployee") 
    public ResponseEntity<List<Employee>>getActiveEmployee() {
        List<Employee>empList=er.getActiveEmployee();

        if(empList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    
    }
}