package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AllergyPatientDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	private String allergyId;
	private String allergyType;
	private String allergyName;
	private String allergySource;
	private String allergySequence;
	private String allerginicity; 
}
