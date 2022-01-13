package com.citiustech.hospitalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.entity.Demographics;
import com.citiustech.hospitalproject.service.Demographics_Service;

@RestController
@RequestMapping("patient")
public class Demographics_Controller {

	private Demographics_Service demographics_Service;
	
	private Demographics demographics;
	
	@Autowired	
	public Demographics_Controller(Demographics_Service demographics_Service) {
		super();
		this.demographics_Service = demographics_Service;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/addDemographic")
	public int saveDemographicData(@RequestBody Demographics demographics) {
		System.out.println(demographics);
		return demographics_Service.addDemographic(demographics);
		
		
	}
	
	@GetMapping("/DemographicInfo")
	public List<Demographics> demographics(){
		return demographics_Service.getAllDemographics();
	}
	
	@GetMapping("/ById/{id}")
	public Optional<Demographics> findDemographicById(@PathVariable int id){
		return demographics_Service.getDemographicById(id);
	}
	
	@PutMapping("/update")
	public String updateDemographic(@RequestBody Demographics demographicdetails, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		try {
			demographics_Service.updateDemographic(demographics);
			return "Patient Details is Successfully Updated";
		}catch(Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	public String deleteDemographicWithId(@PathVariable int id) {
		try {
			demographics_Service.deleteDemographic(id);
			return "Patient Details are deleted Successfully";
		}catch(Exception ex) {
			ex.printStackTrace();
			return ex.toString();
		}
		
	}
	@GetMapping("demographicsbypatientid/{id}")
	public Demographics findDemographicByPatientId(@PathVariable String id){
		return demographics_Service.getDemographicByPatientId(id);
	}
}
