package com.java.spring.service.topic;

import java.util.List;
import java.util.Optional;

import com.java.spring.entity.topic.Topic;

public interface ITopicService {
    Optional<Topic> findTopicById(Long id);

    List<Topic> findTopicByName(String Topic);

    List<Topic> findAllTopics();

    boolean create(Topic Topic);
}
