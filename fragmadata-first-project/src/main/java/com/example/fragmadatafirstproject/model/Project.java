package com.example.fragmadatafirstproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projectId;
	private String projectName;
	private String description;
	private String clientName;
	private Integer teamSize;
	private String startDate;
	private String endDate;
	private String status;

}
