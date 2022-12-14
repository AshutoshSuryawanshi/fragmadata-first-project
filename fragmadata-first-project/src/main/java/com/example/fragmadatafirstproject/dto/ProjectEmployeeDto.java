package com.example.fragmadatafirstproject.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.example.fragmadatafirstproject.model.Employee;
import com.example.fragmadatafirstproject.model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEmployeeDto {
	
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Project projectId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employeeId;
	private LocalDate createdDate;
	
	private String createdBy;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
}
