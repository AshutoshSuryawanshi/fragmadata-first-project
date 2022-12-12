package com.example.fragmadatafirstproject.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto{
	private Integer projectId;
	private String projectName;
	private String description;
	private String clientName;
	private Integer teamSize;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;

}
