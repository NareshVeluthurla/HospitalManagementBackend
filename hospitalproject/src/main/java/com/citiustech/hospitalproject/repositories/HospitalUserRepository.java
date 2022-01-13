package com.citiustech.hospitalproject.repositories;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.hospitalproject.entity.Hospitaluser;
@Repository
public interface HospitalUserRepository extends JpaRepository<Hospitaluser, String>{

	Optional<Hospitaluser> findById(String receiverId);
	
	// ============
	// All method with query For Hospital EMployee



	@Query("from Hospitaluser e where e.role in('Physician','Nurse') ORDER BY userId ASC ")
	@Transactional
	List<Hospitaluser> getAllEmpList();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE role = 'Physician'")
	Long getPhysicianCountofHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE role = 'Nurse'")
	Long getNurseCountofHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.status = 'Active' and e.role in('Physician','Nurse') ")
	Long getActiveHospitaluserEmployeeCount();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.status = 'Deactive' and e.role in('Physician','Nurse') ")
	Long getDeactiveHospitaluserEmployeeCount();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.status = 'Blocked' and e.role in('Physician','Nurse') ")
	Long getBlockedHospitaluserEmployeeCount();



	@Query("from Hospitaluser e where status =:empStatus and e.role in('Physician','Nurse') ORDER BY userId ASC ")
	@Transactional
	List<Hospitaluser> getEmpListofHospitalUserBasedOnStatus(String empStatus);
	
	
		//All method with query For Hospital Patient
		
	@Query(value = "FROM Hospitaluser e WHERE e.role = 'Patient'")
	List<Hospitaluser> getallPatientHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.role = 'Patient'")
	Long getCountofallPatientHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.role = 'Patient' and e.status = 'Active' ")
	Long getCountofallActivePatientHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.role = 'Patient' and e.status = 'Deactive' ")
	Long getCountofallDeactivePatientHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.role = 'Patient' and e.status = 'Blocked' ")
	Long getCountofallBlockedPatientHospitaluser();



	@Query(value = "SELECT COUNT(*) FROM Hospitaluser e WHERE e.role = 'Patient' and e.status = 'Inactive' ")
	Long getCountofallInactivePatientHospitaluser();



	@Query("from Hospitaluser e where status =:patientStatus and e.role = 'Patient' ORDER BY userId ASC ")
	@Transactional
	List<Hospitaluser> getPatientListofHospitalUserBasedOnStatus(String patientStatus);

	List<Hospitaluser> findByRole(String role);
}