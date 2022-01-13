package com.citiustech.hospitalproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;

import lombok.Data;


@Entity
@Data
public class Demographics {
	@Id
	@Column(name = "demographic_Id ", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int demographicId;
	
	@Check(constraints = "title in ('Mr.','Ms.','Mrs.','Dr.')")
	@NotBlank(message = "Kindly select the title.")
	@Column(name = "title", nullable = false, length = 4)
	private String title;
	
	@NotBlank(message = "First name cannot be empty")
	@Size(min = 2, message = "Please don’t use abbreviations")
	@Column(name = "firstName", nullable = false, length = 30)
	private String firstName;
	
	@NotBlank(message = "Last name cannot be empty")
	@Size(min = 2, message = "Please don’t use abbreviations")
	@Column(name = "lastName", nullable = false, length = 30)
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 40, unique = true)
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String mailId;
	
	@Check(constraints = "Gender in ('Male','Female','Other')")
	@NotBlank(message = "Gender is a required field.")
	@Column(nullable = false, length = 6)
	private String gender;
	

    @Column(name = "dob", nullable = false)
    @PastOrPresent(message = "Birthday cannot be future date")
    private Date dateOfBirth;
    
	@Column(nullable = false)
	private Integer age;
	

    @Column(name = "contactNumber", nullable = false)
    @NotEmpty(message = "Please provide the telephone number")
    private String contactNumber;
    
	@Column(nullable = false)
	@NotBlank(message = "Race field cannot be empty.")
	private String race;
	
	@Column(nullable = false)
	@NotBlank(message = "Ethnicity field cannot be empty.")
	private String ethnicity;
	
	@Column(nullable = false)
	@NotBlank(message = "Languages Known cannot be empty")
	private String languagesKnown;
	
	@Column(nullable = false)
	private String address;

//	@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emergencyId")
	private EmergencyContactInfo emergencyContactInfo; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientAllergyId")
	private List<AllergyPatientDetails> allergyPatientDetails;
	
	private String patientId;

}