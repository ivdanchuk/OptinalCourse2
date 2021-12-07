package com.java.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.spring.dto.CourseDTO;
import com.java.spring.entity.Course;
import com.java.spring.entity.CourseReg;
import com.java.spring.entity.Topic;
import com.java.spring.entity.User;
import com.java.spring.service.impl.CourseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
	@Autowired
	CourseServiceImpl courseServiceImpl;

	@Autowired
	TopicRepository topicRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void findAll() {
		List<Course> courses = courseServiceImpl.findAll();
		assertThat(courses.get(0).getTopic().getName()).isEqualTo("Backend");
		assertThat(courses.get(0).getUser().getEmail()).isEqualTo("maksym@gmail.com");
	}

	@Test
	void addNewCourse() {
		Topic topic = topicRepository.findByName(ConstantTest.TEST_TOPIC_NAME1).get(0);
		User user = userRepository.findByLogin("testtutor@gmail.com").get();
		Set<CourseReg> usersCourses = new HashSet<>();
		Course course = new Course(-1l, "TestCourse1", 24, LocalDate.now(), LocalDate.now(), topic, user, 0, 0,
				usersCourses);
		courseServiceImpl.createCourse(course.toDTO());
	}

	@Test
	void delCourse() {
		Topic topic = topicRepository.findByName(ConstantTest.TEST_TOPIC_NAME1).get(0);
		User user = userRepository.findByLogin("testtutor@gmail.com").get();
		CourseDTO courseDTO = CourseDTO.of(-1l, "TestCourse2", 24, LocalDate.now(), LocalDate.now(), topic, user, 0, 0,
				new HashSet<>());
		courseServiceImpl.createCourse(courseDTO);
		Course course = courseServiceImpl.findCourseByName("TestCourse2").get();
		courseServiceImpl.deleteCourse(course);
	}
}
