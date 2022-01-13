package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.hospitalproject.entity.Demographics;

public interface Demographics_Service {

	public int addDemographic(Demographics e);

	public List<Demographics> getAllDemographics();

	public Optional<Demographics> getDemographicById(int id);

	public void updateDemographic(Demographics e);

	public void deleteDemographic(int id);

	public Demographics getDemographicByPatientId(String id);
}