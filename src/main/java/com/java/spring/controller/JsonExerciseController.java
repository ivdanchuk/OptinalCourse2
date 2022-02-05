package com.java.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.spring.dto.user.ReadUserDTO;
import com.java.spring.entity.user.User;
import com.java.spring.exception.UserNotFoundException;
import com.java.spring.repository.RoleRepository;
import com.java.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/json")
public class JsonExerciseController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    public User userOfReadUserDTO (ReadUserDTO readUserDTO) throws JsonProcessingException {
        Optional result = userRepository.findUserByEmail(readUserDTO.getEmail());
        User user = new User();
        if (result.isPresent()){
            user = (User) result.get();
            user.setUsersCourses(null); // objectMapper.writeValueAsString выдает StackOverflow без этого
            ObjectMapper objectMapper = new ObjectMapper();
            String userJson = objectMapper.writeValueAsString(user);
        }else {
            //trow custom exception
            throw new UserNotFoundException(readUserDTO.getEmail());
        }
        return user;
    }

    @GetMapping(value="/objectMapper")
    public String getUser(@RequestBody String jsonString) throws JsonProcessingException {
        //получили строку json из body
        ObjectMapper objectMapper = new ObjectMapper();
        //получили DTO
        ReadUserDTO readUserDTO = objectMapper.readValue(jsonString, ReadUserDTO.class);

        //
        User user = userOfReadUserDTO(readUserDTO);
        String jsonOfUser = objectMapper.writeValueAsString(user);
        return jsonOfUser;
    }

    @GetMapping(value="/validator")
    public String dtoValidator (@Valid @RequestBody ReadUserDTO readUserDTO){
        // вернули строку если прошла валидатция
        return "dto is validated";
    }
}
