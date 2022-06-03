package com.testmasterhost.demo.repositoriesTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.annotation.Rollback;

import com.testmasterhost.demo.entities.UserEntity;
import com.testmasterhost.demo.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void testUserCreate() {
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setEmail("user2@mail.com");
		userEntity1.setPassword("user2");
		userEntity1.setFirstname("user");
		userEntity1.setLastname("two");
		
		UserEntity savedUserEntity1 = userRepository.save(userEntity1);
		
		UserEntity existUserEntity1 = testEntityManager.find(UserEntity.class, savedUserEntity1.getId());
		
		assertThat(existUserEntity1.getEmail()).isEqualTo(userEntity1.getEmail());
	}
	@Test
	public void testFindUserByEmail() {
		String email = "user1@mail.com";
		UserEntity userEntity = userRepository.findByEmail(email);
		assertThat(userEntity).isNotNull();
	}

}
