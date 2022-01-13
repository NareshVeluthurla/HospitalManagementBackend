package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.hospitalproject.entity.Patient;

public interface IPatientService {

	// public String patientIDCheck(String patientId);

	public String patientEmailCheck(String emailId);

	public String savePatient(Patient patient);

	public List<Patient> fetchAllPatient();

	public String editPatStatus(String patientId, String status);
	
	public Long getCountofallPatient();

	public Long getCountofallActivePatient();

	public Long getCountofallDeactivePatient();

	public Long getCountofallBlockedPatient();

	public Long getCountofallInactivePatient();

	public Optional<Patient> getPatientsById(String id);

}
