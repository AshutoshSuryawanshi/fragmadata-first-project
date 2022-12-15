package com.example.fragmadatafirstproject.dto;

import java.util.List;

import com.example.fragmadatafirstproject.model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponce {
	private String date;
	private List<Project> empList;
}