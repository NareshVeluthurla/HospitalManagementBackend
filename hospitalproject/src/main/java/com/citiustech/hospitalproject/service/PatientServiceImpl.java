package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Patient;
import com.citiustech.hospitalproject.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public String patientEmailCheck(String emailId) {
		Patient patEntity = new Patient();
		patEntity.setEmailId(emailId);

		Example<Patient> example = Example.of(patEntity);

		Optional<Patient> findOne = patientRepo.findOne(example);
		if (findOne.isPresent()) {
			return emailId + " already exit --> Try with other";
		} else {
			return "Unique";
		}
	}

	@Override
	public String savePatient(Patient patient) {
		String emailCheck = patientEmailCheck(patient.getEmailId());
		if (emailCheck == "Unique") {
			patient.setStatus("Inactive");
			System.out.println(patient);
			Patient patientSaved = patientRepo.save(patient);
			return "Patient ID " + patientSaved.getPatientId() + " Saved Successfully";
		} else if (emailCheck != "Unique") {
			return "EmailId or EmpID Already Exit";
		} else {
			return "";
		}
	}

	@Override
	public List<Patient> fetchAllPatient() {
		return patientRepo.findAll();
	}

	@Override
	public String editPatStatus(String patientId, String status) {
		if (patientRepo.existsById(patientId)) {
			Patient findPatient = patientRepo.findById(patientId).get();
			findPatient.setStatus(status);
			patientRepo.save(findPatient);
			return "Patient " + patientId + " status updated";
		} else {
			return patientId + " not found";
		}
	}

	@Override
	public Long getCountofallPatient() {
		return patientRepo.count();
	}

	@Override
	public Long getCountofallActivePatient() {
		Long count = patientRepo.getActivePatientCount();
		return count;
	}

	@Override
	public Long getCountofallDeactivePatient() {
		Long count = patientRepo.getDeactivePatientCount();
		return count;
	}

	@Override
	public Long getCountofallBlockedPatient() {
		Long count = patientRepo.getBlockedPatientCount();
		return count;
	}

	@Override
	public Long getCountofallInactivePatient() {
		Long count = patientRepo.getInactivePatientCount();
		return count;
	}

	@Override
	public Optional<Patient> getPatientsById(String id) {
		
		return patientRepo.findById(id);
	}

}
