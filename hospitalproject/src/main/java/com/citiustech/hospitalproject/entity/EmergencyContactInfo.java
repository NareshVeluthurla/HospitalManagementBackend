package com.citiustech.hospitalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class EmergencyContactInfo {

//	@Autowired
//	public Demographics demographics;

	@Id
	@Column(name = "e_id", nullable = false, unique = true)
	@GeneratedValue
	private int e_id;
	@Column(nullable = false, length = 30)
	@NotBlank(message = "First name cannot be empty")
	@Size(min = 2, message = "Please don’t use abbreviations")
	private String firstName;

	@Column(nullable = false, length = 30)
	@NotBlank(message = "Last name cannot be empty")
	@Size(min = 2, message = "Please don’t use abbreviations")
	private String lastName;

	@Column(nullable = false)
	@NotNull(message = "Please select Relationship")
	private String relationship;

	@Column(nullable = false, length = 40, unique = true)
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Column
	@NotEmpty(message = "Please provide the telephone number")
	private String phoneNumber;

	@Column(nullable = false)
	private Boolean accessToPortal;

	@Column(nullable = false)
	private String address;

	
	

}
