package com.testmasterhost.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.testmasterhost.demo.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
	UserEntity findByEmail(String email);

}
