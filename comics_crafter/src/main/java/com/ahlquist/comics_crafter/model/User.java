package com.ahlquist.comics_crafter.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ToString(includeFieldNames=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
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

}
