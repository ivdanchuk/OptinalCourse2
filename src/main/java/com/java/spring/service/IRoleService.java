package com.java.spring.service;

import java.util.List;
import java.util.Optional;

import com.java.spring.entity.Role;

public interface IRoleService {
	Optional<Role> findRoleById(Long id);

	List<Role> findAllRoles();

	Optional<Role> findRoleByName(String role);

	boolean create(Role role);
}