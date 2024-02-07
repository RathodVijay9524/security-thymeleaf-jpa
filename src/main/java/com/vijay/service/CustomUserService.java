package com.vijay.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vijay.entity.User;
import com.vijay.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
				.orElseThrow(()-> new UsernameNotFoundException("Username or Email not found exception"));
		
		Set<GrantedAuthority> auth = user.getRoles().stream()
				.map(role-> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toSet());
		
		return new org.springframework.security.core.userdetails.User(usernameOrEmail,user.getPassword(),auth);
	}

}
