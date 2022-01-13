package com.citiustech.hospitalproject.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Hospitaluser {

	@Id
	@GenericGenerator(name = "sequence_user_id", strategy = "com.citiustech.hospitalproject.sequence.HospitalUserIdGenerator")
	@GeneratedValue(generator = "sequence_user_id")
	private String userId;
	private String title;
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String role;
	private String emailId;
	private String password;
	private String specialization;
//	private Date dateOfJoining;
	private String status;
	
	private Long contactNumber;

	@CreationTimestamp
	@Column(name = "Created_Date", updatable = false)
	private LocalDate createdate;

	@UpdateTimestamp
	@Column(name = "Updated_Date", insertable = false)
	private LocalDate updateddate;

}
