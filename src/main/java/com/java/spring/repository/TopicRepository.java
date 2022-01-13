package com.java.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.spring.entity.topic.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
	@Query("SELECT t FROM Topic t where t.name = :name")
	List<Topic> findByName(@Param("name") String name);
}
