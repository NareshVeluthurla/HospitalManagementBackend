package com.citiustech.hospitalproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.citiustech.hospitalproject.entity.PatientVisitDetail;

public interface PatientVisitRepo extends CrudRepository<PatientVisitDetail,Integer>{
    PatientVisitDetail findById(int id);

	Iterable<PatientVisitDetail> findByUserId(String id);

	Iterable<PatientVisitDetail> findByPatientId(String id);

	PatientVisitDetail findByAppointmentId(int id);

	PatientVisitDetail findByVisitId(int id);
}
