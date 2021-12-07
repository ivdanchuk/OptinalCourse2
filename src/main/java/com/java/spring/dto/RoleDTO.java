package com.java.spring.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
	private Long id;

	@NotBlank
	@Email
	private String name;

	public static RoleDTO of(Long id, String name) {
		return new RoleDTO(id, name);
	}
}
