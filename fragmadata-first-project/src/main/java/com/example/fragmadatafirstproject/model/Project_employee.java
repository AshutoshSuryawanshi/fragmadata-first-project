package com.example.fragmadatafirstproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
	
public class Project_employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Project project_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee_id;

	private String start_date;
	private String end_date;
	private String status;
	private String created_date;
	private String created_by;
	
}
