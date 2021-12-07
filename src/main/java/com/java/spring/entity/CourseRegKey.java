package com.java.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CourseRegKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	Long userId;

	@Column(name = "course_id")
	Long courseId;
}
