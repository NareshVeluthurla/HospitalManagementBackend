package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.hospitalproject.entity.Hospitaluser;

public interface UserService {

	public Hospitaluser save(Hospitaluser e);

	public Hospitaluser getEmployeeByEmail(String email);

	
	//=========================
	public String saveHospitaluserEmployee(Hospitaluser Hospitaluser);

	public String emailCheck(String emailId);

	public List<Hospitaluser> fetchAllHospitaluserEmployee();
	
	public String editHospitaluserEmpStatus(String userId, String status);
	
	public Long getCountofallHospitaluserEmployee();
	
	public Long getCountofallActiveHospitaluserEmployee();
	
	public Long getCountofallDeactiveHospitaluserEmployee();
	
	public Long getCountofallBlockedHospitaluserEmployee();
	
	
	
	//All methods  For Hospital Patient
	
	
	
	public List<Hospitaluser> fetchAllPatient();

	public String editHospitaluserPatientStatus(String patientId, String status);
	
	public Long getCountofallPatient();
	
	public Long getCountofallActivePatient();
	
	public Long getCountofallDeactivePatient();
	
	public Long getCountofallBlockedPatient();
	
	public Long getCountofallInactivePatient();

	

	public List<Hospitaluser> fetchAllActiveEmployeeList();

	public List<Hospitaluser> fetchAllDeactiveEmployeeList();

	public List<Hospitaluser> fetchAllBlockedEmployeeList();

	public List<Hospitaluser> fetchAllActivePatientList();

	public List<Hospitaluser> fetchAllDeactivePatientList();

	public List<Hospitaluser> fetchAllBlockedPatientList();

	public Optional<Hospitaluser> getEmployeeById(String id);
	public List<Hospitaluser> fetchAllPendingStatusPatientList();

}
