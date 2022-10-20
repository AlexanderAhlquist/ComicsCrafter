package com.ahlquist.comics_crafter.model;

/*
 * This model represents the projects which users can create and manage. 
 */
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long project_id;
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
	
	@ManyToMany(mappedBy = "projects")
	private Set<User> users;
	@ManyToMany(mappedBy = "projects")
	private Set<Printing> printings;
	@ManyToMany(mappedBy = "projects")
	private Set<Paper> papers;
	
	public Project(Integer pages, String print_format, Double height, Double width, String binding_style,
			String additional_features, String description, Double sale_price, Double cost_to_produce,
			Integer completion_status) {
		super();
		this.pages = pages;
		this.print_format = print_format;
		this.height = height;
		this.width = width;
		this.binding_style = binding_style;
		this.additional_features = additional_features;
		this.description = description;
		this.sale_price = sale_price;
		this.cost_to_produce = cost_to_produce;
		this.completion_status = completion_status;
	}
	public Project() {}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public String getPrint_format() {
		return print_format;
	}
	public void setPrint_format(String print_format) {
		this.print_format = print_format;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public String getBinding_style() {
		return binding_style;
	}
	public void setBinding_style(String binding_style) {
		this.binding_style = binding_style;
	}
	public String getAdditional_features() {
		return additional_features;
	}
	public void setAdditional_features(String additional_features) {
		this.additional_features = additional_features;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
	public Double getCost_to_produce() {
		return cost_to_produce;
	}
	public void setCost_to_produce(Double cost_to_produce) {
		this.cost_to_produce = cost_to_produce;
	}
	public Integer getCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(Integer completion_status) {
		this.completion_status = completion_status;
	}
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", pages=" + pages + ", print_format=" + print_format + ", height="
				+ height + ", width=" + width + ", binding_style=" + binding_style + ", additional_features="
				+ additional_features + ", description=" + description + ", sale_price=" + sale_price
				+ ", cost_to_produce=" + cost_to_produce + ", completion_status=" + completion_status + "]";
	};
	
}
