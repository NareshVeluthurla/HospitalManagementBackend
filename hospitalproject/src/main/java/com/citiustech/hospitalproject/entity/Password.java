package com.citiustech.hospitalproject.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Password {
	  @Id
	 @GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	private String password;
	private LocalDate generatedDate;
	private LocalDate expiryDate;

}
