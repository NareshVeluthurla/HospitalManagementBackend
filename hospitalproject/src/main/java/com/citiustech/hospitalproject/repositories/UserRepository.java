package com.citiustech.hospitalproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.hospitalproject.entity.Hospitaluser;
@Repository
public interface UserRepository extends JpaRepository<Hospitaluser, String> {

	Hospitaluser findByEmailId(String username);

}