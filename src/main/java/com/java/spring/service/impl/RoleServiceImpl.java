package com.java.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.entity.Role;
import com.java.spring.repository.RoleRepository;
import com.java.spring.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	RoleRepository RoleRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findRoleById(Long id) {
		return RoleRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAllRoles() {
		return RoleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findRoleByName(String role) {
		return RoleRepository.findByName(role);
	}

	@Override
	@Transactional
	public boolean create(Role role) {
		RoleRepository.save(role);
		return true;
	}
}
