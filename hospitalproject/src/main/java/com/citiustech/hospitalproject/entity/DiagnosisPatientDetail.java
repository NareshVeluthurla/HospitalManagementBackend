package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DiagnosisPatientDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	private String diagnosisCode; 
	
	private String diagnosisDescription; 
	
	private String otherDiagnosisCode; 
	
	private String otherDiagnosisDescription;
	
	private String diagnosisIsDeprecated;
}
