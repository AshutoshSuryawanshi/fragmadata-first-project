package com.example.fragmadatafirstproject.dto;

import java.util.List;

import com.example.fragmadatafirstproject.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponce {
private String date;
private List <Employee> empList;
}
