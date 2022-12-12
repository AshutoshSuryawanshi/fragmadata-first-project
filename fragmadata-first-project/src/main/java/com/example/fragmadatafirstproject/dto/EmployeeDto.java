package com.example.fragmadatafirstproject.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeDto{
	private int employeeId;
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
	private LocalDate createdDate;
	private String createdBy;

}
