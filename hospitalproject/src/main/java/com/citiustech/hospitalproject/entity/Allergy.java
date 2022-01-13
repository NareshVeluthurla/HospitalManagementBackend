package com.citiustech.hospitalproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Allergy {
	@Id
	private String allergyId;
	private String allergyType;
	private String allergyName;
	private String allergySource;
	private String allergySequence;
	private String allerginicity; 

}
 