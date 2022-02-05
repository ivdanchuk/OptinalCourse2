package com.java.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.java.spring.service.topic.TopicServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.spring.entity.topic.Topic;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class TopicRepositoryTest {
    List<Topic> topics;
    TopicServiceImpl topicService;

    @Before
    public void setup() {
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(1l, "Topic1"));
        topics.add(new Topic(2l, "Topic2"));
        topicService = mock(TopicServiceImpl.class);
    }

    @Test
    public void findAll() {
        when(topicService.findAllTopics()).thenReturn(topics);
        assertThat(topicService.findAllTopics()).hasSize(2);
        assertThat(topicService.findAllTopics().get(0).getName()).isEqualTo("Topic1");
    }
}
