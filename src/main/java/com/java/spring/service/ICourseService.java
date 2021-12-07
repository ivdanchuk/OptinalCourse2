package com.java.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.java.spring.dto.CourseDTO;
import com.java.spring.entity.Course;

public interface ICourseService {
	@Transactional
	boolean createCourse(CourseDTO user);

	boolean updateCourse(Course user);

	@Transactional(readOnly = true)
	Optional<Course> findCourseByName(String login);

	@Transactional(readOnly = true)
	Optional<Course> findCourseById(long id);

	@Transactional(readOnly = true)
	List<Course> findAll();

	boolean deleteCourse(Course course);
}
