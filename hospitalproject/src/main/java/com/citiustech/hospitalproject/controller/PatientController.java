package com.citiustech.hospitalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.entity.Patient;
import com.citiustech.hospitalproject.service.IPatientService;

@RestController
public class PatientController {

	@Autowired
	private IPatientService ipatientService;

	@GetMapping("getPatientsById/{id}")
	public Optional<Patient> findPatientsWithId(@PathVariable String id) {
		return ipatientService.getPatientsById(id);
	}

}
