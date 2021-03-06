package com.testmasterhost.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.testmasterhost.demo.details.CustomUserDetails;
import com.testmasterhost.demo.entities.UserEntity;
import com.testmasterhost.demo.repositories.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepo.findByEmail(email);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(userEntity);
	}

}
