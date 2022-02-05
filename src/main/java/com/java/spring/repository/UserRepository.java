package com.java.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.spring.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " + "END FROM User u WHERE u.email = :email")
	boolean existsByLogin(@Param("email") String email);

	//@Query("SELECT u FROM User u where u.email = :email")
	//Optional<User> findByLogin(@Param("email") String email);
	Optional<User> findUserByEmail(String email);
}
