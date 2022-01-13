package com.citiustech.hospitalproject.service;

import java.util.List;

import com.citiustech.hospitalproject.entity.Allergy;
import com.citiustech.hospitalproject.entity.Diagnosis;
import com.citiustech.hospitalproject.entity.Drug;
import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.entity.Procedure;


public interface DataService {

	public List<Hospitaluser> getEmployeeNamesBasedOnRole(String role);

	public List<Diagnosis> getAllDiagnosis();

	public List<Procedure> getAllProcedure();

	public List<Drug> getAllDrug();

	public List<Allergy> getAllAllergy();
}
