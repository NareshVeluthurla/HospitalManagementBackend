package com.citiustech.hospitalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Allergy;
import com.citiustech.hospitalproject.entity.Diagnosis;
import com.citiustech.hospitalproject.entity.Drug;
import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.entity.Procedure;
import com.citiustech.hospitalproject.repositories.AllergyRepo;
import com.citiustech.hospitalproject.repositories.DiagnosisRepo;
import com.citiustech.hospitalproject.repositories.DrugRepo;
import com.citiustech.hospitalproject.repositories.HospitalUserRepository;
import com.citiustech.hospitalproject.repositories.ProcedureRepo;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	HospitalUserRepository userRepo;
	
	@Autowired
	DiagnosisRepo diagRepo;
	@Autowired
	ProcedureRepo procedureRepo;
	@Autowired
	DrugRepo drugRepo;
	@Autowired
	AllergyRepo allergyRepo;
	@Override
	public List<Hospitaluser> getEmployeeNamesBasedOnRole(String role) {
		return userRepo.findByRole(role);
	
	}
	

	@Override
	public List<Diagnosis> getAllDiagnosis() {
		return diagRepo.findAll();
	
	}


	@Override
	public List<Procedure> getAllProcedure() {
		// TODO Auto-generated method stub
		return procedureRepo.findAll();
	}


	@Override
	public List<Drug> getAllDrug() {
		// TODO Auto-generated method stub
		return drugRepo.findAll();
	}
	
	@Override
	public List<Allergy> getAllAllergy() {
		// TODO Auto-generated method stub
		return allergyRepo.findAll();
	}

}
