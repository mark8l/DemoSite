package com.testmasterhost.demo.passwordencoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static void main(String[] args) {		
		
		String rawPassword = "user1";
		String encodedPassword = encoder.encode(rawPassword);		
		System.out.println(encodedPassword);
	}
	
	public static String passwordEncoder(String password) {
		
		return encoder.encode(password);
		
	}

}
