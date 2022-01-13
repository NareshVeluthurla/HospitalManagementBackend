package com.citiustech.hospitalproject.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;

@Entity
public class Available {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slotId;
	private String slotTime;
	
	@Check(constraints="isAvail in('yes','no')")
	private String isAvail;
	private String employeeId;
	private Date date;
	
	public int getSlotId() {
		return slotId;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	
	public String getIsAvail() {
		return isAvail;
	}
	public void setIsAvail(String isAvail) {
		this.isAvail = isAvail;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
