package com.java.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.spring.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false " + "END FROM Course c WHERE c.name = :name")
	boolean existsByName(@Param("name") String name);

	@Query("SELECT c FROM Course c where c.name = :name")
	Optional<Course> findByName(@Param("name") String name);
}
