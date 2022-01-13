package com.java.spring.entity.course;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.spring.dto.CourseDTO;

import com.java.spring.entity.topic.Topic;
import com.java.spring.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "start_date")
	private LocalDate start_date;

	@Column(name = "end_date")
	private LocalDate end_date;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "counter")
	private Integer counter;

	@Column(name = "state")
	private Integer state;

	@OneToMany(mappedBy = "course")
	Set<CourseReg> usersCourses;

	public static Course of(Long id, String name, int duration, LocalDate start_date, LocalDate end_date, Topic topic,
			User user, int counter, int state, Set<CourseReg> students) {
		return new Course(id, name, duration, start_date, end_date, topic, user, counter, state, students);
	}

	public static Course fromDTO(CourseDTO userDTO) {
		return Course.of(userDTO.getId(), userDTO.getName(), userDTO.getDuration(), userDTO.getStart_date(),
				userDTO.getEnd_date(), userDTO.getTopic(), userDTO.getUser(), userDTO.getCounter(), userDTO.getState(),
				userDTO.getStudents());
	}

	public CourseDTO toDTO() {
		return CourseDTO.of(id, name, duration, start_date, end_date, topic, user, counter, state, usersCourses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the start_date
	 */
	public LocalDate getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public LocalDate getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return the usersCourses
	 */
	public Set<CourseReg> getUsersCourses() {
		return usersCourses;
	}

	/**
	 * @param usersCourses the usersCourses to set
	 */
	public void setUsersCourses(Set<CourseReg> usersCourses) {
		this.usersCourses = usersCourses;
	}

}
