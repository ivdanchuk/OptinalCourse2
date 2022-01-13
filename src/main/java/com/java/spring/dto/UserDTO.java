package com.java.spring.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.java.spring.entity.role.Role;
import com.java.spring.entity.course.CourseReg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(min = 3, max = 20)
	private String password;
	private String f_name;
	private String l_name;

	private Role role;
	private Set<CourseReg> courses;

	public static UserDTO of(Long id, String email, String password, String f_name, String l_name, Role role,
			Set<CourseReg> courses) {
		return new UserDTO(id, email, password, f_name, l_name, role, courses);
	}
}
