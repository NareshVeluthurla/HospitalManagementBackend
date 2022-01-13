package com.citiustech.hospitalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.entity.Allergy;
import com.citiustech.hospitalproject.entity.Diagnosis;
import com.citiustech.hospitalproject.entity.Drug;
import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.entity.Procedure;
import com.citiustech.hospitalproject.entity.Specialization;
import com.citiustech.hospitalproject.service.DataService;
import com.citiustech.hospitalproject.service.SpecializationService;

@RestController
@RequestMapping("/data")
public class DataController {

	private DataService dataService;


	private SpecializationService iSpecService;
	
	@Autowired
	public DataController(DataService dataService,SpecializationService iSpecService) {
		super();
		this.dataService = dataService;
		this.iSpecService= iSpecService;
	}

	
	
	@GetMapping("getempnamesbasedonrole/{role}")
	public List<Hospitaluser> getEmpNamesbasedOnRole(@PathVariable String role) {
		System.out.println("role"+role);
		return dataService.getEmployeeNamesBasedOnRole(role);
		  
	}
	
	@GetMapping("diagnosisDetail")
	public List<Diagnosis> getAllDiagnosis() {
		return dataService.getAllDiagnosis();
		  
	}
	@GetMapping("procedureDetail")
	public List<Procedure> getAllProcedure() {
		return dataService.getAllProcedure();
		  
	}
	@GetMapping("drugsDetail")
	public List<Drug> getAllDrug() {
		return dataService.getAllDrug();
		  
	}
	
	@GetMapping("allergyDetail")
	public List<Allergy> getAllAllergy() {
		return dataService.getAllAllergy();
		  
	}

	@GetMapping("/specialization")
	public List<Specialization> getAllSpecialization() {
		return iSpecService.fetchAllSpecialization();
}
}
