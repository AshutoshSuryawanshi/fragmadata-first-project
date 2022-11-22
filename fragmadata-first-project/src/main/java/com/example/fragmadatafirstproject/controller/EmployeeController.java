package com.example.fragmadatafirstproject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.service.EmployeeService;



@CrossOrigin("*") 
@RestController 
public class EmployeeController {
    @Autowired 
    EmployeeService er;
    

    @PostMapping(value="/postEmployee", consumes= {"application/xml", "application/json"}) 
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee eid) {
        System.out.println(eid);
        Employee Employee=er.saveEmployee(eid);
        return new ResponseEntity<Employee>(Employee, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeList") 
    public ResponseEntity<List<Employee>>getEmployeeList() {
        List<Employee>empList=er.getEmployeeList();

        if(empList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{eid}") 
    public ResponseEntity<String>deleteEmployee(@PathVariable Integer eid) {
        er.deltEmployee(eid);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/updateEmployee/{eid}") 
    public ResponseEntity<Employee>updateEmployee(@PathVariable Integer eid, @RequestBody Employee e) {
        Employee loan=er.updateEmployeeData(eid, e);
        return new ResponseEntity<Employee>(loan, HttpStatus.OK);
    }

    @GetMapping(value="/getSingleEmployee/{eid}") 
    public ResponseEntity<Optional<Employee>>getSingleData(@PathVariable ("eid") int eid) {

        Optional<Employee>loan=er.getSingleEmployeeData(eid);
        return new ResponseEntity<Optional<Employee>>(loan, HttpStatus.OK);
    }
    
    @GetMapping("/getActiveEmployeeList") 
    public ResponseEntity<List<Employee>>getActiveEmployeeList() {
        List<Employee>empList=er.getActiveEmployee();

        if(empList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }
}