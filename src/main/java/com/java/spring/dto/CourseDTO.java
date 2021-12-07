package com.java.spring.dto;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.java.spring.entity.Topic;
import com.java.spring.entity.User;
import com.java.spring.entity.CourseReg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
	private Long id;
	@NotBlank
	private String name;
	private int duration;
	private LocalDate start_date;
	private LocalDate end_date;
	private Topic topic;
	private User user;
	private int counter;
	private int state;
	Set<CourseReg> students;

	public static CourseDTO of(Long id, String name, int duration, LocalDate start_date, LocalDate end_date,
			Topic topic, User user, int counter, int state, Set<CourseReg> students) {
		return new CourseDTO(id, name, duration, start_date, end_date, topic, user, counter, state, students);
	}
}
