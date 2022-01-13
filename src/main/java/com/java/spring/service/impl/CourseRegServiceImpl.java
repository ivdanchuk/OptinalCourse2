package com.java.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.entity.course.CourseReg;
import com.java.spring.repository.CourseRegRepository;
import com.java.spring.service.ICourseRegService;

@Service
public class CourseRegServiceImpl implements ICourseRegService {
	@Autowired
	private CourseRegRepository usersCoursesRepository;

	@Override
	public boolean createUsersCourses(CourseReg usersCourses) {
		usersCoursesRepository.save(usersCourses);
		return true;
	}

	@Override
	public boolean updateUsersCourses(CourseReg usersCourses) {
		usersCoursesRepository.save(usersCourses);
		return true;
	}

//	@Override
//	public List<UsersCourses> findByCourse(Course course) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<UsersCourses> findByUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<CourseReg> findAll() {
		return usersCoursesRepository.findAll();
	}
}
