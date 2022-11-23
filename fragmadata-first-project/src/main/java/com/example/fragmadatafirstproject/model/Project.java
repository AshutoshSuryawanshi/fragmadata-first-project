package com.example.fragmadatafirstproject.model;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer project_id;
	private String project_name;
	private String description;
	private String client_name;
	private Integer team_size;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "start_date")
	private Project_employee start_date;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "end_date")
	private Project_employee end_date;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status")
	private Project_employee status;
	
}
