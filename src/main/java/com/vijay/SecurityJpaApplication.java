package com.vijay;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vijay.entity.Role;
import com.vijay.entity.User;

import com.vijay.repository.UserRepository;

@SpringBootApplication
public class SecurityJpaApplication implements CommandLineRunner {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	    
	@Autowired
	private UserRepository userRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		User user = new User();
		user.setName("Ajay Rathod");
		user.setEmail("omajay88@gmail.com");
		user.setUsername("omajay");
		user.setPassword(passwordEncoder.encode("ajay"));
		
		
		Role role = new Role();
		role.setName("USER");

		// Create a collection of roles
		Set<Role> roles = new HashSet<>();
		roles.add(role);

		user.setRoles(roles);

		//userRepository.save(user);
		
		
		
	}

}
