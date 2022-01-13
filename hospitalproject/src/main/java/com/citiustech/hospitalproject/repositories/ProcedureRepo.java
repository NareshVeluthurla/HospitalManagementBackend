package com.citiustech.hospitalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.hospitalproject.entity.Procedure;

public interface ProcedureRepo extends JpaRepository<Procedure, Integer>{

}
