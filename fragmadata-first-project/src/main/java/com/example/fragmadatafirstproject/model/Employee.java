package com.example.fragmadatafirstproject.model;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	private String employeeName;
	private String designation;
	private String joiningDate;
	private String emailId;
	private long mobileNo;
	private String gender;
	private String status;
	private String address;
	private String city;
	private String state;
	private String country;
	private String createdDate;
	private String createdBy;
	
	

}
