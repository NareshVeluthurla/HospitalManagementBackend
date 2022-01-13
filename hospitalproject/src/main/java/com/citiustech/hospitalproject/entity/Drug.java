package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Drug {
	@Id
	private int drugId;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;
}
