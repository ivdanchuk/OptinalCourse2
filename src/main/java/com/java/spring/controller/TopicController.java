package com.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring.constant.PAGES;
import com.java.spring.entity.Topic;
import com.java.spring.service.impl.TopicServiceImpl;

@Controller
@RequestMapping(value = "/topics")
public class TopicController {
	@Autowired
	private TopicServiceImpl topicService;

	final static Logger logger = LogManager.getLogger();

	@GetMapping
	public String getMainPage(HttpSession session, Model model) {
		List<Topic> topics = new ArrayList<>();
		topics = topicService.findAllTopics();
//		session.setAttribute("users", users);
		model.addAttribute("topics", topics);
		return PAGES.TOPICS_PAGE;
	}
}
