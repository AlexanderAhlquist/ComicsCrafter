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

@Entity
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paper_id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "papers_projects", joinColumns = @JoinColumn(name = "paper_id", referencedColumnName = "paper_id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"))
	private Collection<Project> projects;

	private double height;
	private double width;
	private double gsm;
	private double textweight;
	private double coverweight;
	private double bond;
	private int sheets;
	private String brand;
	private double price;
	private double price_per_page;
	private String material;
	private String color;
	private String feature;
	private String additionalDescription;
	private String link_to_vendor;

	public Paper(double height, double width, double gsm, double textweight, double coverweight, double bond,
			int sheets, String brand, double price, double price_per_page, String material, String color,
			String feature, String additionalDescription, String link_to_vendor) {
		this.height = height;
		this.width = width;
		this.gsm = gsm;
		this.textweight = textweight;
		this.coverweight = coverweight;
		this.bond = bond;
		this.sheets = sheets;
		this.brand = brand;
		this.price = price;
		this.price_per_page = price_per_page;
		this.material = material;
		this.color = color;
		this.feature = feature;
		this.additionalDescription = additionalDescription;
		this.link_to_vendor = link_to_vendor;
	}

	public Paper() {
	}

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
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

	public double getGsm() {
		return gsm;
	}

	public void setGsm(double gsm) {
		this.gsm = gsm;
	}

	public double getTextweight() {
		return textweight;
	}

	public void setTextweight(double textweight) {
		this.textweight = textweight;
	}

	public double getCoverweight() {
		return coverweight;
	}

	public void setCoverweight(double coverweight) {
		this.coverweight = coverweight;
	}

	public double getBond() {
		return bond;
	}

	public void setBond(double bond) {
		this.bond = bond;
	}

	public int getSheets() {
		return sheets;
	}

	public void setSheets(int sheets) {
		this.sheets = sheets;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice_per_page() {
		return price_per_page;
	}

	public void setPrice_per_page(double price_per_page) {
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
	}

}
