package com.vijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
