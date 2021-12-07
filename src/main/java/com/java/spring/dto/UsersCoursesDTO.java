package com.java.spring.dto;

import java.time.LocalDate;

import com.java.spring.entity.Course;
import com.java.spring.entity.User;
import com.java.spring.entity.CourseRegKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersCoursesDTO {
	CourseRegKey id;
	User user;
	Course course;
	Integer mark;
	LocalDate reg_date;

	public static UsersCoursesDTO of(CourseRegKey id, User user, Course course, Integer mark, LocalDate reg_date) {
		return new UsersCoursesDTO(id, user, course, mark, reg_date);
	}
}
