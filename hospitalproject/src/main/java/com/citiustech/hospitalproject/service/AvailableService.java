package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.hospitalproject.entity.Available;

public interface AvailableService {
	
	public List<Available> getAllAvailable();

	public Optional<Available> getAvailableById(int id);

	public String updateAvailable(int id,Available e);

	public String deleteAvailable(int id);
	
	public List<Available> getgetAvailByEmpId(String id);
}
