package com.citiustech.hospitalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.hospitalproject.entity.Diagnosis;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer>{

}
