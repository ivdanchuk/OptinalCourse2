package com.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.CourseReg;
import com.java.spring.entity.CourseRegKey;

public interface CourseRegRepository extends JpaRepository<CourseReg, CourseRegKey> {
//	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false " + "END FROM Course c WHERE c.name = :name")
//	boolean existsByName(@Param("name") String name);

//	@Query("SELECT c FROM Course c where c.name = :name")
//	Optional<Course> findByName(@Param("name") String name);
}
