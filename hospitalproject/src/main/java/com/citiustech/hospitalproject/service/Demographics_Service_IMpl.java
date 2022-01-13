package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Demographics;
import com.citiustech.hospitalproject.repositories.Demographics_Repo;

@Service
public class Demographics_Service_IMpl implements Demographics_Service{
	
	@Autowired
	private Demographics_Repo details_Repo;
	
	
//	@Autowired
//	private EmergencyContactInfo ecinfo;

	@Override
	public int addDemographic(Demographics pd) {
		Demographics pdNo=  details_Repo.save(pd);
		return pdNo.getDemographicId();
		
	}

	@Override
	public List<Demographics> getAllDemographics() {
		return details_Repo.findAll();
	}

	@Override
	public Optional<Demographics> getDemographicById(int id) {
		return details_Repo.findById(id);
	}

	@Override
	public void updateDemographic( Demographics e) {
		int id = e.getDemographicId();
		Optional<Demographics> ddetails = details_Repo.findById(id);
		Demographics demographicsDetails=ddetails.get();
		System.out.println( demographicsDetails.getEmergencyContactInfo().getE_id());
		demographicsDetails.setEmergencyContactInfo(e.getEmergencyContactInfo());
		
		System.out.println(demographicsDetails);
		
		System.out.println(e);
	}

	@Override
	public void deleteDemographic(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Demographics getDemographicByPatientId(String id) {
		// TODO Auto-generated method stub
		return details_Repo.findByPatientId(id);
	}
}