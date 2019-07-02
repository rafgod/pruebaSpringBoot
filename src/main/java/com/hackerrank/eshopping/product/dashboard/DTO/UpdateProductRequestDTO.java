package com.hackerrank.eshopping.product.dashboard.DTO;

public class UpdateProductRequestDTO {

    private Double retail_price; // The updated retail price. The value may remain unchanged.
    private Double discounted_price; // The updated discounted price. The value may remain unchanged.
    private Boolean availability; // The updated availability. The value may remain unchanged.

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

}
