package com.example.fragmadatafirstproject.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	private Project projectId;

	@OneToOne(cascade = CascadeType.ALL)
	private Employee employeeId;

	private String createdDate;
	private String createdBy;
	private String startDate;
	private String endDate;
	private String status;

//	@OneToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "startDate")
//	private Project startDate;
//
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "endDate")
//	private Project endDate;
//
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "status")
//	private Project status;
//	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "createdDate")
//	private Employee createdDate;	
//	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "createdBy")
//	private Employee createdBy;

}
