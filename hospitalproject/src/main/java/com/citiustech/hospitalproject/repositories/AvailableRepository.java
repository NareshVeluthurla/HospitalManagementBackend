package com.citiustech.hospitalproject.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citiustech.hospitalproject.entity.Available;

@Repository
public interface AvailableRepository extends JpaRepository<Available, Integer> {

	@Transactional
	@Modifying
	@Query("from Available where employeeId = :employeeId")
	List<Available> getAvailByEmpId(@Param(value = "employeeId") String id);
}
