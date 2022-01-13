package com.citiustech.hospitalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.hospitalproject.entity.Allergy;


public interface AllergyRepo extends JpaRepository<Allergy, Integer> {

}
