package com.java.spring.dto.user;

import com.java.spring.entity.course.CourseReg;
import com.java.spring.entity.role.Role;
import com.java.spring.dto.user.validator.ReadUserDTOValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@ReadUserDTOValidator
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadUserDTO {
    private Long id;

    @Email
    private String email;

    private String f_name;

    private String l_name;
}
