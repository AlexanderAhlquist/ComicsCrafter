package com.ahlquist.comics_crafter.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.*;
/*
 * This model represents the user data which will be stored on the site. It has a many to many relationship with the project model.
 */

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	
	@Column(name="user_name")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;

	@ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_projects", 
	joinColumns = @JoinColumn(
			name = "u_id", 
			referencedColumnName = "user_id"), 
	inverseJoinColumns = @JoinColumn(
			name = "pro_id", 
			referencedColumnName = "project_id"))
	private Collection<Project> projects;
	public User(Long user_id, Collection<Project> projects, String username, String password, String email) {

		this.user_id = user_id;
		this.projects = projects;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User(String username, String password, String email) {

		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User() {};
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Collection<Project> getProjects() {
		return projects;
	}
	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", projects=" + projects + ", username=" + username + ", password="
				+ password + ", email=" + email + "]";
	}

}
