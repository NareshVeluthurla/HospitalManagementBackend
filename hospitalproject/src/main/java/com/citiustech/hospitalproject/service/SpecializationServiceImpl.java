package com.citiustech.hospitalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Specialization;
import com.citiustech.hospitalproject.repositories.SpecializationRepository;

@Service
public class SpecializationServiceImpl implements SpecializationService{

	@Autowired
	private SpecializationRepository specRepo;

	@Override
	public List<Specialization> fetchAllSpecialization() {
		return specRepo.findAll();
	}
}
