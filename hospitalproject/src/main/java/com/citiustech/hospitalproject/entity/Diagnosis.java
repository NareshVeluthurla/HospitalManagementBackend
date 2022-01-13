package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Diagnosis {
	@Id
	private String diagnosisCode;
	private String diagnosisDescription;
	
}
