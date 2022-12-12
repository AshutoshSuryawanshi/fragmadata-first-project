package com.example.fragmadatafirstproject.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEmployeeDto {
	
	private Integer id;
	private ProjectDto projectId;
	private EmployeeDto employeeId;
	private LocalDate createdDate;
	private String createdBy;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
}
