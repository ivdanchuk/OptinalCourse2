package com.java.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.java.spring.dto.UserDTO;
import com.java.spring.entity.User;

public interface IUserService {
	@Transactional
	boolean createUser(User user);

	boolean updateUser(User user);

	@Transactional(readOnly = true)
	Optional<User> findUserByLogin(String login);

	@Transactional(readOnly = true)
	Optional<User> findUserById(long id);

	@Transactional(readOnly = true)
	List<User> findAll();
}
