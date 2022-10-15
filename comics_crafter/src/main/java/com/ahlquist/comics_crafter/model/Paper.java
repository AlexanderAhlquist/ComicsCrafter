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
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paper_id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "papers_projects", 
			joinColumns = @JoinColumn(
					name = "pap_id", referencedColumnName = "paper_id"), 
			inverseJoinColumns = @JoinColumn(
					name = "pro_id", referencedColumnName = "project_id"))
	private Collection<Project> projects;

	private Double height;
	private Double width;
	private Double gsm;
	private Double textweight;
	private Double coverweight;
	private Double bond;
	private Integer sheets;
	private String brand;
	private Double price;
	private Double price_per_page;
	private String material;
	private String color;
	private String feature;
	private String additionalDescription;
	private String link_to_vendor;
}
