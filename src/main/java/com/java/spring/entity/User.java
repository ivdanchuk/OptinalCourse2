package com.java.spring.entity;

import java.io.Serializable;
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

import com.java.spring.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "f_name")
	private String f_name;

	@Column(name = "l_name")
	private String l_name;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(mappedBy = "user")
	Set<CourseReg> usersCourses;

	public static User of(Long id, String email, String password, String f_name, String l_name, Role role,
			Set<CourseReg> courses) {
		return new User(id, email, password, f_name, l_name, role, courses);
	}

	public static User fromDTO(UserDTO userDTO) {
		return User.of(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getF_name(),
				userDTO.getL_name(), userDTO.getRole(), userDTO.getCourses());
	}

	public UserDTO toDTO() {
		return UserDTO.of(id, email, null, f_name, l_name, role, usersCourses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}

	@Override
	public boolean equals(Object obj) {
		// test
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the f_name
	 */
	public String getF_name() {
		return f_name;
	}

	/**
	 * @param f_name the f_name to set
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
