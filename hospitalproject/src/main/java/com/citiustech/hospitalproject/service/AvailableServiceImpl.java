package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Available;
import com.citiustech.hospitalproject.repositories.AvailableRepository;

@Service
public class AvailableServiceImpl implements AvailableService{
	
	@Autowired
	private AvailableRepository availableRepo;

	@Override
	public List<Available> getAllAvailable() {
		
		return availableRepo.findAll();
	}

	@Override
	public Optional<Available> getAvailableById(int id) {
		return availableRepo.findById(id);
	}

	@Override
	public String updateAvailable(int id, Available e) {
		if (availableRepo.existsById(id)) {
			Available app = availableRepo.findById(id).get();
			app.setDate(e.getDate());
			app.setEmployeeId(e.getEmployeeId());
			app.setIsAvail(e.getIsAvail());
			app.setSlotTime(e.getSlotTime());
			
			availableRepo.save(app);
			return "Physician ID " + id + " Updated Successfully";
		} else {
			return "Physician ID " + id + " Not Found";
		}
	}

	@Override
	public String deleteAvailable(int id) {
		if (availableRepo.existsById(id)) {
			availableRepo.deleteById(id);
			return id + " deleted successfully";
		} else {
			return "Physician ID " + id + " not found";
		}
	}

	@Override
	public List<Available> getgetAvailByEmpId(String id) {
		
		return availableRepo.getAvailByEmpId(id);
	}

}