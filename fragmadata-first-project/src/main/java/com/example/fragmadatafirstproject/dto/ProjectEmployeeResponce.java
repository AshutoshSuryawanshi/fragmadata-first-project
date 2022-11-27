package com.example.fragmadatafirstproject.dto;

import java.util.List;

import com.example.fragmadatafirstproject.model.ProjectEmployee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEmployeeResponce {
	private String date;
	private List<ProjectEmployee> empList;
}
