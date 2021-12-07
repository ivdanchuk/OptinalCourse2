package com.java.spring.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDTO {
	private Long id;

	@NotBlank
	private String name;

	public static TopicDTO of(Long id, String name) {
		return new TopicDTO(id, name);
	}
}
