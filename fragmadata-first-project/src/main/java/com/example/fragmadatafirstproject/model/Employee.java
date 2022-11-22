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
	private Integer employee_id;
	private String employee_name;
	private String designation;
	private String joining_date	;
	private String email_id;
	private long mobile_no;
	private String gender;
	private String status;
	private String address;
	private String city;
	private String state;
	private String country;
	private String created_date;
	private String created_by;
	

}
