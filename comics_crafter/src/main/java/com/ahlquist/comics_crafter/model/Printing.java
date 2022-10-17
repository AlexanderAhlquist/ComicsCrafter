package com.ahlquist.comics_crafter.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Printing {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer printing_process_id;

	@ManyToMany(
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL)
	@JoinTable(
		name = "printing_projects", 
		joinColumns = @JoinColumn(
				name = "pri_id", 
				referencedColumnName = "printing_process_id"), 
		inverseJoinColumns = @JoinColumn(
				name = "pro_id", 
				referencedColumnName = "project_id"))
	private Collection<Project> projects;

	private String ink;
	private String ink_color;
	private Double time_per_copy;
	
	public Printing(Integer printing_process_id, Collection<Project> projects, String ink, String ink_color,
			Double time_per_copy) {
		super();
		this.printing_process_id = printing_process_id;
		this.projects = projects;
		this.ink = ink;
		this.ink_color = ink_color;
		this.time_per_copy = time_per_copy;
	}
	public Printing(String ink, String ink_color, Double time_per_copy) {
		super();
		this.ink = ink;
		this.ink_color = ink_color;
		this.time_per_copy = time_per_copy;
	}
	public Printing() {};
	public Integer getPrinting_process_id() {
		return printing_process_id;
	}
	public void setPrinting_process_id(Integer printing_process_id) {
		this.printing_process_id = printing_process_id;
	}
	public Collection<Project> getProjects() {
		return projects;
	}
	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}
	public String getInk() {
		return ink;
	}
	public void setInk(String ink) {
		this.ink = ink;
	}
	public String getInk_color() {
		return ink_color;
	}
	public void setInk_color(String ink_color) {
		this.ink_color = ink_color;
	}
	public Double getTime_per_copy() {
		return time_per_copy;
	}
	public void setTime_per_copy(Double time_per_copy) {
		this.time_per_copy = time_per_copy;
	}
	@Override
	public String toString() {
		return "Printing [printing_process_id=" + printing_process_id + ", projects=" + projects + ", ink=" + ink
				+ ", ink_color=" + ink_color + ", time_per_copy=" + time_per_copy + "]";
	}
}
