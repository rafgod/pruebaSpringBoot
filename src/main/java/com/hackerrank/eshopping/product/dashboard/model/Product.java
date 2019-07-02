package com.hackerrank.eshopping.product.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "RETAIL_PRICE")
    private Double retailPrice;
    @Column(name = "DISCOUNTED_PRICE")
    private Double discountedPrice;
    @Column(name = "AVAILABILITY")
    private Boolean availability;

    public Product() {
    }

    public Product(Long id, String name, String category, Double retailPrice, Double discountedPrice, Boolean availability) {
	this.id = id;
	this.name = name;
	this.category = category;
	this.retailPrice = retailPrice;
	this.discountedPrice = discountedPrice;
	this.availability = availability;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public Double getRetailPrice() {
	return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
	this.retailPrice = retailPrice;
    }

    public Double getDiscountedPrice() {
	return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
	this.discountedPrice = discountedPrice;
    }

    public Boolean getAvailability() {
	return availability;
    }

    public void setAvailability(Boolean availability) {
	this.availability = availability;
    }
}
