package com.example.fragmadatafirstproject.controller;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.fragmadatafirstproject.model.Project_employee;
import com.example.fragmadatafirstproject.service.Project_employeeService;



@CrossOrigin("*") 
@RestController 
public class Project_employeeController {
    @Autowired 
    Project_employeeService er;
    

    @PostMapping(value="/postProject_employee", consumes= {"application/xml", "application/json"}) 
    public ResponseEntity<Project_employee>saveProject_employee(@RequestBody Project_employee start_date) {
        System.out.println(start_date);
        Project_employee Project_employee=er.saveProject_employee(start_date);
        return new ResponseEntity<Project_employee>(Project_employee, HttpStatus.CREATED);
    }

    @GetMapping("/getProject_employeeList/") 
    public ResponseEntity<List<Project_employee>>getProject_employeeList() {
        List<Project_employee>empList=er.getProject_employeeList();

        if(empList.isEmpty()) {
            return new ResponseEntity<List<Project_employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Project_employee>>(empList, HttpStatus.OK);
    
}
}
