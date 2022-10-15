package com.ahlquist.comics_crafter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Project {
	@Id
	@GeneratedValue
	private Integer project_id;
	private Integer pages;
	private String print_format;
	private Double height;
	private Double width;
	private String binding_style;
	private String additional_features;
	private String description;
	private Double sale_price;
	private Double cost_to_produce;
	private Integer completion_status;
	
}
