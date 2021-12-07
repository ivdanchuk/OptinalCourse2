package com.java.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.entity.Topic;
import com.java.spring.repository.TopicRepository;
import com.java.spring.service.ITopicService;

@Service
public class TopicServiceImpl implements ITopicService {
	@Autowired
	TopicRepository TopicRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Topic> findTopicById(Long id) {
		return TopicRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Topic> findAllTopics() {
		return TopicRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Topic> findTopicByName(String Topic) {
		return TopicRepository.findByName(Topic);
	}

	@Override
	@Transactional
	public boolean create(Topic Topic) {
		TopicRepository.save(Topic);
		return true;
	}
}
