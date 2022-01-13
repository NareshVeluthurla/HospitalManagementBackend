package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.repositories.HospitalUserRepository;
import com.citiustech.hospitalproject.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	HospitalUserRepository hospitaluserRepo;
	@Autowired
	UserRepository repository;

	@Override
	public Hospitaluser save(Hospitaluser e) {
		return hospitaluserRepo.save(e);
	}

	@Override
	public Hospitaluser getEmployeeByEmail(String email) {

		return repository.findByEmailId(email);
	}


	@Override
	public String emailCheck(String emailId) {
		Hospitaluser HospitaluserempEntity = new Hospitaluser();
		HospitaluserempEntity.setEmailId(emailId);
		Example<Hospitaluser> example = Example.of(HospitaluserempEntity);

		Optional<Hospitaluser> findOne = hospitaluserRepo.findOne(example);
		if (findOne.isPresent()) {
			return emailId + " already exit --> Try with other";
		} else {
			return "Unique";
		}
	}

	@Override
	public String saveHospitaluserEmployee(Hospitaluser Hospitaluser) {
		String emailCheck = emailCheck(Hospitaluser.getEmailId());
		if (emailCheck == "Unique") {
			String randomPwd = GenerateRandomPwd(6);
			Hospitaluser.setPassword(randomPwd);
			Hospitaluser.setStatus("Active");
			Hospitaluser employeeSaved = hospitaluserRepo.save(Hospitaluser);
			return "Employee ID " + employeeSaved.getUserId() + " Saved Successfully";
		} else if (emailCheck != "Unique") {
			return "EmailId Already Exit";
		} else {
			return "";
		}
	}

	private static String GenerateRandomPwd(int length) {
		Random rnd = new Random();
		String str = "1234567890ABCDEFGHIJKabcdefghijkLMNOPQRSTUVWXYZlmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(str.charAt(rnd.nextInt(str.length())));
		}
		return sb.toString();
	}

	@Override
	public List<Hospitaluser> fetchAllHospitaluserEmployee() {
		return hospitaluserRepo.getAllEmpList();
	}

	@Override
	public String editHospitaluserEmpStatus(String userId, String status) {
		if (hospitaluserRepo.existsById(userId)) {
			Hospitaluser findEmployee = hospitaluserRepo.findById(userId).get();
			findEmployee.setStatus(status);
			hospitaluserRepo.save(findEmployee);
			return "Employee " + userId + " status updated";
		} else {
			return userId + " not found";
		}
	}

	@Override
	public Long getCountofallHospitaluserEmployee() {
		Long physicianCount = hospitaluserRepo.getPhysicianCountofHospitaluser();
		Long nurseCount = hospitaluserRepo.getNurseCountofHospitaluser();
		return physicianCount + nurseCount;
	}

	@Override
	public Long getCountofallActiveHospitaluserEmployee() {
		return hospitaluserRepo.getActiveHospitaluserEmployeeCount();
	}

	@Override
	public Long getCountofallDeactiveHospitaluserEmployee() {
		return hospitaluserRepo.getDeactiveHospitaluserEmployeeCount();
	}

	@Override
	public Long getCountofallBlockedHospitaluserEmployee() {
		return hospitaluserRepo.getBlockedHospitaluserEmployeeCount();
	}

	// Implimentation of Hospital Patient

	@Override
	public List<Hospitaluser> fetchAllPatient() {
		return hospitaluserRepo.getallPatientHospitaluser();
	}

	@Override
	public String editHospitaluserPatientStatus(String patientId, String status) {
		if (hospitaluserRepo.existsById(patientId)) {
			Hospitaluser findEmployee = hospitaluserRepo.findById(patientId).get();
			findEmployee.setStatus(status);
			hospitaluserRepo.save(findEmployee);
			return "Employee " + patientId + " status updated";
		} else {
			return patientId + " not found";
		}

	}

	@Override
	public Long getCountofallPatient() {
		return hospitaluserRepo.getCountofallPatientHospitaluser();
	}

	@Override
	public Long getCountofallActivePatient() {
		return hospitaluserRepo.getCountofallActivePatientHospitaluser();
	}

	@Override
	public Long getCountofallDeactivePatient() {
		return hospitaluserRepo.getCountofallDeactivePatientHospitaluser();
	}

	@Override
	public Long getCountofallBlockedPatient() {
		return hospitaluserRepo.getCountofallBlockedPatientHospitaluser();
	}

	@Override
	public Long getCountofallInactivePatient() {
		return hospitaluserRepo.getCountofallInactivePatientHospitaluser();
	}

	@Override
	public List<Hospitaluser> fetchAllActiveEmployeeList() {
		return hospitaluserRepo.getEmpListofHospitalUserBasedOnStatus("Active");
	}

	@Override
	public List<Hospitaluser> fetchAllDeactiveEmployeeList() {
		return hospitaluserRepo.getEmpListofHospitalUserBasedOnStatus("Deactive");
	}

	@Override
	public List<Hospitaluser> fetchAllBlockedEmployeeList() {
		return hospitaluserRepo.getEmpListofHospitalUserBasedOnStatus("Blocked");
	}

	@Override
	public List<Hospitaluser> fetchAllActivePatientList() {
		return hospitaluserRepo.getPatientListofHospitalUserBasedOnStatus("Active");
	}

	@Override
	public List<Hospitaluser> fetchAllDeactivePatientList() {
		return hospitaluserRepo.getPatientListofHospitalUserBasedOnStatus("Deactive");
	}

	@Override
	public List<Hospitaluser> fetchAllBlockedPatientList() {
		return hospitaluserRepo.getPatientListofHospitalUserBasedOnStatus("Blocked");
	}



	@Override
	public Optional<Hospitaluser> getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return hospitaluserRepo.findById(id);
	}
	@Override
	public List<Hospitaluser> fetchAllPendingStatusPatientList() {
		return hospitaluserRepo.getPatientListofHospitalUserBasedOnStatus("Inactive");
	}



}