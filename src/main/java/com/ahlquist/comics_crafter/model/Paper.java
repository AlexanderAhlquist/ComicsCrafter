package com.ahlquist.comics_crafter.model;

import java.io.Serializable;
import java.util.Set;

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
/*
 * This model represents different types of paper which the users might use in their projects. It has a many to many relationship with projects.
 */
@Entity
@Table
public class Paper implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paper_id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "papers_projects", 
			joinColumns = @JoinColumn(
					name = "pap_id", referencedColumnName = "paper_id"), 
			inverseJoinColumns = @JoinColumn(
					name = "pro_id", referencedColumnName = "project_id"))
	private Set<Project> projects;
	
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
	
	public Paper(Long paper_id, Set<Project> projects, Double height, Double width, Double gsm,
			Double textweight, Double coverweight, Double bond, Integer sheets, String brand, Double price,
			 String material, String color, String feature, String additionalDescription,
			String link_to_vendor, Double price_per_page) {
		super();
		this.paper_id = paper_id;
		this.projects = projects;
		this.height = height;
		this.width = width;
		this.gsm = gsm;
		this.textweight = textweight;
		this.coverweight = coverweight;
		this.bond = bond;
		this.sheets = sheets;
		this.brand = brand;
		this.price = price;
		this.price_per_page= price_per_page;
		this.material = material;
		this.color = color;
		this.feature = feature;
		this.additionalDescription = additionalDescription;
		this.link_to_vendor = link_to_vendor;
	}

	public Paper() {}
	public Long getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(Long paper_id) {
		this.paper_id = paper_id;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
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
	public Double getGsm() {
		return gsm;
	}
	public void setGsm(Double gsm) {
		this.gsm = gsm;
	}
	public Double getTextweight() {
		return textweight;
	}
	public void setTextweight(Double textweight) {
		this.textweight = textweight;
	}
	public Double getCoverweight() {
		return coverweight;
	}
	public void setCoverweight(Double coverweight) {
		this.coverweight = coverweight;
	}
	public Double getBond() {
		return bond;
	}
	public void setBond(Double bond) {
		this.bond = bond;
	}
	public Integer getSheets() {
		return sheets;
	}
	public void setSheets(Integer sheets) {
		this.sheets = sheets;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice_per_page() {
		return price_per_page;
	}
	public void setPrice_per_page(Double price_per_page) {
		this.price_per_page = price_per_page;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getAdditionalDescription() {
		return additionalDescription;
	}
	public void setAdditionalDescription(String additionalDescription) {
		this.additionalDescription = additionalDescription;
	}
	public String getLink_to_vendor() {
		return link_to_vendor;
	}
	public void setLink_to_vendor(String link_to_vendor) {
		this.link_to_vendor = link_to_vendor;
	}
	@Override
	public String toString() {
		return "Paper [paper_id=" + paper_id + ", projects=" + projects + ", height=" + height + ", width=" + width
				+ ", gsm=" + gsm + ", textweight=" + textweight + ", coverweight=" + coverweight + ", bond=" + bond
				+ ", sheets=" + sheets + ", brand=" + brand + ", price=" + price + ", price_per_page=" + price_per_page
				+ ", material=" + material + ", color=" + color + ", feature=" + feature + ", additionalDescription="
				+ additionalDescription + ", link_to_vendor=" + link_to_vendor + "]";
	};
}
