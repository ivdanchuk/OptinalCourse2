package com.java.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.spring.entity.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest()

public class TopicRepositoryTest {
	@Autowired
	TopicRepository topicRepository;

	@Test
	void findAll() throws Exception {
		List<Topic> topics = topicRepository.findAll();
		assertThat(topics).hasSize(4);
		assertThat(topics.get(0).getName()).isEqualTo("Backend");
		assertThat(topics.get(3).getName()).isEqualTo("Frontend");
	}

	@Test
	void findByName() throws Exception {
		List<Topic> topics = topicRepository.findByName("DeVops");
		assertThat(topics).hasSize(1);
		assertThat(topics.get(0).getName()).isEqualTo("DevOps");
	}

	@Test
	void addNewTopic() {
		Topic topic = new Topic(-1l, "TestTopicInserted");
		topicRepository.save(topic);
		assertThat(topicRepository.findByName("TestTopicInserted").get(0).getName()).isEqualTo("TestTopicInserted");
	}
}
