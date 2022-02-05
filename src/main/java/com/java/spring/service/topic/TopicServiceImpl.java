package com.java.spring.service.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java.spring.validator.SecurityDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.entity.topic.Topic;
import com.java.spring.repository.TopicRepository;
import com.java.spring.service.topic.ITopicService;

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
    public List<Topic> findTopicByName(String topic) {
        if (SecurityDataValidator.validateName(topic)) {
            return TopicRepository.findByName(topic);
        } else {
            return new ArrayList<Topic>();
        }
    }

    @Override
    @Transactional
    public boolean create(Topic topic) {
        TopicRepository.save(topic);
        return true;
    }
}
