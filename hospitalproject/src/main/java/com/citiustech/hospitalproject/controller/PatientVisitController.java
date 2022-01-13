package com.citiustech.hospitalproject.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.dto.PatientVisitDetailsDTO;
import com.citiustech.hospitalproject.entity.PatientVisitDetail;
import com.citiustech.hospitalproject.service.PatientVisitService;

@RestController
@RequestMapping("/visit")
public class PatientVisitController {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	PatientVisitService patientVisitService;

	public PatientVisitController(PatientVisitService patientVisitService) {
		super();
		this.patientVisitService = patientVisitService;
	}
	
	@GetMapping(path="patientvisitdetails/{id}")
	public Iterable<PatientVisitDetail> getPatientVisitDetails(@PathVariable String id) {
		 return patientVisitService.getAllVisitDetails(id);
 
	}
	
	
	@GetMapping(path="patientvisitdetailsbyPatientId/{id}")
	public Iterable<PatientVisitDetail> getPatientVisitDetailsByPatientId(@PathVariable String id) {
		 return patientVisitService.getAllVisitDetailsByPatientId(id);
 
	}
	
	@GetMapping(path="patientvisitdetailsbyAppointmentId/{id}")
	public PatientVisitDetail getPatientVisitDetailsByAppointmentId(@PathVariable int id) {
		 return patientVisitService.getAllVisitDetailsByAppointmentId(id);
 
	}
	@PostMapping(path="patientvisitpartial",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public int savePatientVisit(@RequestBody PatientVisitDetailsDTO  details) {
		System.out.println(details);
		PatientVisitDetail patientVisit = modelMapper.map(details, PatientVisitDetail.class);
		System.out.println(patientVisit);
		 return patientVisitService.saveVisitDetails(patientVisit);
 
	}

	
	@PostMapping(path="patientvisit",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public void updatePatientVisit(@RequestBody PatientVisitDetailsDTO  details) {
		System.out.println(details);
		PatientVisitDetail patientVisit = modelMapper.map(details, PatientVisitDetail.class);
		System.out.println(patientVisit);
		 patientVisitService.updateVisitDetails(patientVisit);
 
	}

}
