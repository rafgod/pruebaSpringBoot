package com.hackerrank.eshopping.product.dashboard.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * DTO creado para enmascarar la entidad
 * */
public class ProductDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String category;
    private Double retail_price;
    private Double discounted_price;
    private Boolean availability;
    @JsonIgnore
    private Integer discountPercentage;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String category, Double retail_price, Double discounted_price, Boolean availability) {
	this.id = id;
	this.name = name;
	this.category = category;
	this.retail_price = retail_price;
	this.discounted_price = discounted_price;
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

    public Double getRetail_price() {
	return retail_price;
    }

    public void setRetail_price(Double retail_price) {
	this.retail_price = retail_price;
    }

    public Double getDiscounted_price() {
	return discounted_price;
    }

    public void setDiscounted_price(Double discounted_price) {
	this.discounted_price = discounted_price;
    }

    public Boolean getAvailability() {
	return availability;
    }

    public void setAvailability(Boolean availability) {
	this.availability = availability;
    }

    public Integer getDiscountPercentage() {
	return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
	this.discountPercentage = discountPercentage;
    }

}
