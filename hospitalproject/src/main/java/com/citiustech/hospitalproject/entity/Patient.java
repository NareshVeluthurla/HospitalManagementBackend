package com.citiustech.hospitalproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GenericGenerator(name = "sequence_patient_id", strategy = "com.citiustech.hospitalproject.sequence.PatientIdGenerator")
	@GeneratedValue(generator = "sequence_patient_id")
	private String patientId;
	private String title;
	private String firstName;
	private String lastName;
	private long contactNumber;
	private String emailId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	private List<Password> password;
	private Date dateOfRegistration;
	private String status;

}
