package com.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.constant.PAGES;
import com.java.spring.dto.UserDTO;
import com.java.spring.entity.Role;
import com.java.spring.entity.User;
import com.java.spring.service.impl.RoleServiceImpl;
import com.java.spring.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private RoleServiceImpl roleService;

	final static Logger logger = LogManager.getLogger();

	@GetMapping
	public String getMainPage(HttpSession session, Model model) {
		List<User> users = new ArrayList<>();
		users = userService.findAll();
//		session.setAttribute("users", users);
		model.addAttribute("users", users);
		return PAGES.USERS_PAGE;
	}

	@GetMapping(value = "/edit")
	public String getUserEditPage(@RequestParam(name = "userId") String userId, HttpSession session, Model model) {
		logger.trace("getUserEditPage# userId=" + userId);
		User user = userService.findUserById(Long.parseLong(userId)).get();
		model.addAttribute("user", user);
		return "userForm";
	}

	@PostMapping(value = "/update")
	public String addUser(HttpServletRequest request, @Valid UserDTO userDTO) {
//		Long userId = Long.parseLong(request.getParameter("userId"));
		String roleName = request.getParameter("role_id");
		Role role = roleService.findRoleByName(roleName).get();
		userDTO.setRole(role);
		User user = User.fromDTO(userDTO);
		userService.updateUser(user);
		logger.info("update user with id = " + userDTO.getId());

		return PAGES.USERS_PAGE;
	}
}
