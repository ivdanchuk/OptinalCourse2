package com.java.spring.entity.course;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.java.spring.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m2m_users_courses")
public class CourseReg implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	CourseRegKey id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
    User user;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id")
	Course course;

	@Column(name = "mark")
	Integer mark;

	@Column(name = "reg_date")
	LocalDate reg_date;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseReg other = (CourseReg) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersCourses [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", course=");
		builder.append(course);
		builder.append(", mark=");
		builder.append(mark);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the id
	 */
	public CourseRegKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CourseRegKey id) {
		this.id = id;
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
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the mark
	 */
	public Integer getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(Integer mark) {
		this.mark = mark;
	}

	/**
	 * @return the reg_date
	 */
	public LocalDate getReg_date() {
		return reg_date;
	}

	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}
}
