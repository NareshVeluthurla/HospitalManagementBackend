package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DrugPatientDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String drugCode;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;
} 
