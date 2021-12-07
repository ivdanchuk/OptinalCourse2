package com.java.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("SELECT r FROM Role r where r.name = :name")
	Optional<Role> findByName(@Param("name") String name);
}
