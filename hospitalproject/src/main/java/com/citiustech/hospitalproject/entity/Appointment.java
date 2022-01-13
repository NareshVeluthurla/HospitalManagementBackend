package com.citiustech.hospitalproject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;

import lombok.Data;

@Entity
@Data
@Table(name="Appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String employeeId;
	private String patientId;
	@Size(min=5,max=30,message="minimum 5 & maximum 30 character allowed")
	private String meetingTitle;
	@Size(min=5,max=90,message="minimum 5 & maximum 90 character allowed")
	private String description;
	
	private Date date;
	private String time;
	//private String editHistory;
	@Check(constraints="status in('pending','booked','modified','canceled','completed')")
	private String status;
	private String reason;
	
	
	
	
}
