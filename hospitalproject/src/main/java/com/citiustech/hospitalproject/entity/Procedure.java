package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Procedure {
	@Id
	private int procedureCode;
	private String procedureDescription;

}
