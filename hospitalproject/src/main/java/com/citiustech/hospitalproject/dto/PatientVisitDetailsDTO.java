package com.citiustech.hospitalproject.dto;

import java.util.List;

import com.citiustech.hospitalproject.entity.DiagnosisPatientDetail;
import com.citiustech.hospitalproject.entity.DrugPatientDetail;
import com.citiustech.hospitalproject.entity.ProcedurePatientDetail;

import lombok.Data;

@Data
public class PatientVisitDetailsDTO {
	
	private int visitId;
	
	private int appointmentId;
	
	private String patientId;

	private float height;
	
	private float weight;
	
	private float bloodPressure;
	
	private float bodyTemperature;
	
	private float respirationRate;
	
	private List<DiagnosisPatientDetail> diagnosis;
	
	
	private List<ProcedurePatientDetail> procedure;
	
	
	private List<DrugPatientDetail> drug;
	
	private String userId;
}
