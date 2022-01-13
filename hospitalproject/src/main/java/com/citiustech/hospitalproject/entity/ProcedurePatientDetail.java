package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProcedurePatientDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String procedureCode;
	private String procedureDescription;
	private String otherProcedureCode;
	private String otherProcedureDescription;
	private String procedureIsDeprecated;
}
 