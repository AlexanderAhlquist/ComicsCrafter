package com.ahlquist.comics_crafter.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;

	@ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_projects", 
	joinColumns = @JoinColumn(
			name = "u_id", 
			referencedColumnName = "user_id"), 
	inverseJoinColumns = @JoinColumn(
			name = "pro_id", 
			referencedColumnName = "project_id"))
	private Collection<Project> projects;
	
	private String username;
	private String password;
	private String email;
	public User(Integer user_id, Collection<Project> projects, String username, String password, String email) {

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
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
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
