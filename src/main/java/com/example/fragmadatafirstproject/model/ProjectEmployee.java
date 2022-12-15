package com.example.fragmadatafirstproject.model;

import java.time.LocalDate;
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

	private LocalDate createdDate;
	private String createdBy;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
}
