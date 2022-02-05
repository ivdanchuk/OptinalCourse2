package com.java.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.spring.entity.course.Course;
import com.java.spring.entity.course.CourseReg;
import com.java.spring.entity.course.CourseRegKey;
import com.java.spring.entity.user.User;
import com.java.spring.service.course.CourseRegServiceImpl;
import com.java.spring.service.course.CourseServiceImpl;
import com.java.spring.service.user.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRegTest {
    @Autowired
    CourseRegServiceImpl courseRegServiceImpl;

    @Autowired
    UserServiceImpl userRegServiceImpl;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @Test
    void findAll() {
        List<CourseReg> coursereg = courseRegServiceImpl.findAll();
        assertThat(coursereg).hasSizeGreaterThan(0);
        assertThat(coursereg.get(0).getUser().getEmail()).isEqualTo("ivdanchuk@gmail.com");
    }

    @Test
    void insertNew() {
        List<CourseReg> coursereg = courseRegServiceImpl.findAll();
        CourseRegKey id = new CourseRegKey(6l, 5l);
        User user = userRegServiceImpl.findUserById(6l).get();
        Course course = courseServiceImpl.findCourseById(5).get();
        CourseReg courseReg = new CourseReg(id, user, course, 50, LocalDate.now());
        courseRegServiceImpl.createUsersCourses(courseReg);
    }
}
