package com.vijay.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vijay.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
      Optional<User> findByUsernameOrEmail(String username,String email);

}
