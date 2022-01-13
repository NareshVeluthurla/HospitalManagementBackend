package com.citiustech.hospitalproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class PatientVisitDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitId;

	private int appointmentId;

	private float height; 

	private float weight;

	private float bloodPressure;

	private float bodyTemperature;

	private float respirationRate;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientVisitId")
	private List<DiagnosisPatientDetail> diagnosis;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientVisitId")
	private List<ProcedurePatientDetail> procedure;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientVisitId")
	private List<DrugPatientDetail> drug;
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	private Date dateTime;
	
	private String userId;
	
	private String patientId;

}
