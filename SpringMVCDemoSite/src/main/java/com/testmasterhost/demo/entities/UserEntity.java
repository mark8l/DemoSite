package com.testmasterhost.demo.entities;

import javax.persistence.*;

import com.testmasterhost.demo.passwordencoder.PasswordEncoder;
//import javax.validation.constraints.Email;


@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Email(message="Please provide a valid email address")
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false, length = 64)
	private String password;
	@Column(nullable = false, length = 20)
	private String firstname;
	@Column(nullable = false, length = 20)
	private String lastname;
	public UserEntity() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = PasswordEncoder.passwordEncoder(password);
		
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	

}