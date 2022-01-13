package com.citiustech.hospitalproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citiustech.hospitalproject.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Serializable> {

	@Query(value = "SELECT COUNT(*) FROM Patient p WHERE p.status = 'Active'")
	Long getActivePatientCount();

	@Query(value = "SELECT COUNT(*) FROM Patient p WHERE p.status = 'Deactive'")
	Long getDeactivePatientCount();

	@Query(value = "SELECT COUNT(*) FROM Patient p WHERE p.status = 'Blocked'")
	Long getBlockedPatientCount();

	@Query(value = "SELECT COUNT(*) FROM Patient p WHERE p.status = 'Inactive'")
	Long getInactivePatientCount();

}
