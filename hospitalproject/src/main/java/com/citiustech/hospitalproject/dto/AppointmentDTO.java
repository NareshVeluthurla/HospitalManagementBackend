package com.citiustech.hospitalproject.dto;

import java.util.Date;

import lombok.Data;
@Data
public class AppointmentDTO {
	  private int id;
		private String employeeId;
		private String patientId;
		private String meetingTitle;
		private String description;
		private Date date;
		private String time;
		private String status;
		private String reason;
		private String patientFirstName;
		private String patientLastName;
		private String physicianFirstName;
		private String physicianLastName;
		private String PhysicianTitle;
		private String PatientTitle;

}