package com.java.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.dto.CourseDTO;
import com.java.spring.entity.course.Course;
import com.java.spring.repository.CourseRepository;
import com.java.spring.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	@Transactional
	public boolean createCourse(CourseDTO course) {
		if (courseRepository.existsByName(course.getName()))
			return false;

		courseRepository.save(Course.fromDTO(course));
		return true;
	}

	@Override
	@Transactional
	public boolean updateCourse(Course course) {
		courseRepository.save(course);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Course> findCourseByName(String login) {
		return courseRepository.findByName(login);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Course> findCourseById(long id) {
		return courseRepository.findById(id);
	}

	@Override
	@Transactional
	public boolean deleteCourse(Course course) {
		courseRepository.delete(course);
		return true;
	}

}
