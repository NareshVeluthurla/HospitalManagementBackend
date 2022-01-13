package com.citiustech.hospitalproject.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citiustech.hospitalproject.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	
	@Transactional
	@Modifying
	@Query("from Appointment where employeeId = :employeeId")
	List<Appointment> getAppointmentByEmpId(@Param(value = "employeeId") String id);
	
	@Transactional
	@Modifying
	@Query("from Appointment where patientId = :patientId")
	List<Appointment> getAppointmentByPatientId(@Param(value = "patientId") String id);
	
//	@Transactional
//	@Modifying
//	@Query(value = "select a.id,a.date,a.description,a.employee_id,a.meeting_title,a.patient_id,a.status,a.time,e.title,e.role,e.specialist,e.first_name,"
//			+ " e.last_name,p.titlee,p.first_names, p.last_names from appointment a inner join employee e on a.employee_id=e.employee_id inner join patients p "
//			+ "on p.patient_id=a.patient_id where a.patient_id= :patient_id",nativeQuery = true)
//	List<Object> getTotalByPatientId(@Param(value = "patientId") String id);
}
