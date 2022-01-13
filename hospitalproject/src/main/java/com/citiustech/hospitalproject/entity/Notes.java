package com.citiustech.hospitalproject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String senderId;
	private String senderName;
	private String senderType;
	private String receiverId;
	private String receiverName;
	private String receiverType;
	private String message;
	private Date date;
	private String time;
	private String urgencyLevel;
	private String response;
	private String status;
}
