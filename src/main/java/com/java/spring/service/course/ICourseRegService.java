package com.java.spring.service.course;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.java.spring.entity.course.CourseReg;

public interface ICourseRegService {
    @Transactional
    boolean createUsersCourses(CourseReg usersCourses);

    @Transactional
    boolean updateUsersCourses(CourseReg usersCourses);

    @Transactional(readOnly = true)
    List<CourseReg> findAll();
}
