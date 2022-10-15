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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
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
}
