package com.java.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainPageController {

//	@GetMapping(value = "/info")
	@GetMapping
	public String getInfoPage(HttpSession session, Model model) {
		return "main";
	}
}
