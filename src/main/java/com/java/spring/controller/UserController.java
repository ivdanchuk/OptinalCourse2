package com.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.java.spring.constant.PAGES;
import com.java.spring.dto.user.UserDTO;
import com.java.spring.entity.role.Role;
import com.java.spring.entity.user.User;
import com.java.spring.service.role.RoleServiceImpl;
import com.java.spring.service.user.UserServiceImpl;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;

    final static Logger logger = LogManager.getLogger();

    @GetMapping
    public String getMainPage(Model model) {
        List<User> users = new ArrayList<>();
        users = userService.findAll();
        model.addAttribute("users", users);
        return PAGES.USERS_PAGE;
    }

    @GetMapping(value = "/{id}")
    public String getUserEditPage(@PathVariable(name = "id") long id, Model model) {
        User user = userService.findUserById(id).get();
        model.addAttribute("user", user);
        return "users/userForm";
    }

    @PostMapping(value = "/update")
    public String updateUser(HttpServletRequest request, @Valid UserDTO userDTO) {
        String roleName = request.getParameter("role_id");
        Role role = roleService.findRoleByName(roleName).get();
        userDTO.setRole(role);
        User user = User.fromDTO(userDTO);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String showNewUserForm() {
        return "users/new";
    }

    @PostMapping()
    public String createNewUser(@RequestParam("role_id") long role_id, @Valid UserDTO userDTO) {
        Role role = roleService.findRoleById(role_id).get();
        userDTO.setRole(role);
        userDTO.setId(-1l);
        User user = User.fromDTO(userDTO);
        userService.createUser(user);
        return "redirect:/users";
    }
}
