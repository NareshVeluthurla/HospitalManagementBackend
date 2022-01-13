package com.citiustech.hospitalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.PatientVisitDetail;
import com.citiustech.hospitalproject.repositories.PatientVisitRepo;

@Service
public class PatientVisitServiceImpl implements PatientVisitService {

	@Autowired
	PatientVisitRepo patientVisitRepo;

	@Override
	public Iterable<PatientVisitDetail> getAllVisitDetails(String id) {
		return patientVisitRepo.findByUserId(id);
	}
	@Override
	public Iterable<PatientVisitDetail> getAllVisitDetailsByPatientId(String id) {
		// TODO Auto-generated method stub
		return patientVisitRepo.findByPatientId(id);
	}

	@Override
	public int saveVisitDetails(PatientVisitDetail details) {
		PatientVisitDetail pd = patientVisitRepo.save(details);
		return pd.getVisitId();
	}

	@Override
	public void updateVisitDetails(PatientVisitDetail details) {
		int id = details.getVisitId();
		PatientVisitDetail pddetails = patientVisitRepo.findByVisitId(id);
		System.out.println("update visit details"+pddetails);
		if(pddetails != null) {
			System.out.println("pd not null"+!details.getDiagnosis().isEmpty());
		if(!details.getDiagnosis().isEmpty()) {
			System.out.println("diagnosis present");
			System.out.println("dignosis"+details.getDiagnosis());
			
		pddetails.setDiagnosis(details.getDiagnosis());
		}
		if(!details.getProcedure().isEmpty()) {
		pddetails.setProcedure(details.getProcedure());
		}
		if(!details.getDrug().isEmpty()) {
		pddetails.setDrug(details.getDrug());
		}
		System.out.println(pddetails);
		patientVisitRepo.save(pddetails);
		}
	}
	@Override
	public PatientVisitDetail getAllVisitDetailsByAppointmentId(int id) {
		// TODO Auto-generated method stub
		return patientVisitRepo.findByAppointmentId(id);
	}

	
}
