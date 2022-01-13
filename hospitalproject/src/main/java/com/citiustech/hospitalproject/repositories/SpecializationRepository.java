package com.citiustech.hospitalproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.hospitalproject.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Serializable> {

}