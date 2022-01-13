package com.citiustech.hospitalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.hospitalproject.entity.Drug;

public interface DrugRepo extends JpaRepository<Drug, Integer>{

}
