package com.citiustech.hospitalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.hospitalproject.entity.Demographics;

public interface Demographics_Repo extends JpaRepository<Demographics, Integer> {

	Demographics findByPatientId(String id);


}
