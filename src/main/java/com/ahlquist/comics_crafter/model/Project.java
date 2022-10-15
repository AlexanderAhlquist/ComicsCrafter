package com.ahlquist.comics_crafter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private int project_id;
	private int pages;
	private String print_format;
	private double height;
	private double width;
	private String binding_style;
	private String additional_features;
	private String description;
	private double sale_price;
	private double cost_to_produce;
	private int completion_status;
	public Project(int project_id, int pages, String print_format, double height, double width, String binding_style,
			String additional_features, String description, double sale_price, double cost_to_produce,
			int completion_status) {
		this.project_id = project_id;
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

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPrint_format() {
		return print_format;
	}

	public void setPrint_format(String print_format) {
		this.print_format = print_format;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
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

	public double getSale_price() {
		return sale_price;
	}

	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}

	public double getCost_to_produce() {
		return cost_to_produce;
	}

	public void setCost_to_produce(double cost_to_produce) {
		this.cost_to_produce = cost_to_produce;
	}

	public int getCompletion_status() {
		return completion_status;
	}

	public void setCompletion_status(int completion_status) {
		this.completion_status = completion_status;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", pages=" + pages + ", print_format=" + print_format + ", height="
				+ height + ", width=" + width + ", binding_style=" + binding_style + ", additional_features="
				+ additional_features + ", description=" + description + ", sale_price=" + sale_price
				+ ", cost_to_produce=" + cost_to_produce + ", completion_status=" + completion_status + "]";
	}
	
	
}
