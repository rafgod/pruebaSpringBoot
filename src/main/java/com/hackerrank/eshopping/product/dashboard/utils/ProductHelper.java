package com.hackerrank.eshopping.product.dashboard.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hackerrank.eshopping.product.dashboard.DTO.ProductDTO;
import com.hackerrank.eshopping.product.dashboard.DTO.UpdateProductRequestDTO;
import com.hackerrank.eshopping.product.dashboard.model.Product;

@Component
public class ProductHelper {

    public Product dtoToEntity(ProductDTO product) {
	Product newProduct = new Product();
	newProduct.setId(product.getId());
	newProduct.setName(product.getName());
	newProduct.setCategory(product.getCategory());
	newProduct.setRetailPrice(product.getRetail_price());
	newProduct.setDiscountedPrice(product.getDiscounted_price());
	newProduct.setAvailability(product.getAvailability());
	return newProduct;
    }

    public Product dtoToEntity(UpdateProductRequestDTO request, Product prod) {
	prod.setAvailability(request.getAvailability());
	prod.setDiscountedPrice(request.getDiscounted_price());
	prod.setRetailPrice(request.getRetail_price());
	return prod;
    }

    public ProductDTO entityToDTO(Product product) {
	ProductDTO productDTO = new ProductDTO();
	productDTO.setAvailability(product.getAvailability());
	productDTO.setCategory(product.getCategory());
	productDTO.setDiscounted_price(product.getDiscountedPrice());
	productDTO.setId(product.getId());
	productDTO.setName(product.getName());
	productDTO.setRetail_price(product.getRetailPrice());
	return productDTO;
    }

    public List<ProductDTO> entityToDTO(List<Product> result) {
	List<ProductDTO> productList = new ArrayList<>();
	for (Product product : result) {
	    ProductDTO prod = new ProductDTO();
	    prod.setAvailability(product.getAvailability());
	    prod.setCategory(product.getCategory());
	    prod.setDiscounted_price(product.getDiscountedPrice());
	    prod.setId(product.getId());
	    prod.setName(product.getName());
	    prod.setRetail_price(product.getRetailPrice());
	    productList.add(prod);
	}
	return productList;
    }

    public List<ProductDTO> entityToDTODiscount(List<Product> result) {
	List<ProductDTO> productList = new ArrayList<>();
	for (Product product : result) {
	    ProductDTO prod = new ProductDTO();
	    prod.setAvailability(product.getAvailability());
	    prod.setCategory(product.getCategory());
	    prod.setDiscounted_price(product.getDiscountedPrice());
	    prod.setId(product.getId());
	    prod.setName(product.getName());
	    prod.setRetail_price(product.getRetailPrice());
	    prod.setDiscountPercentage(getPercentage(product));
	    productList.add(prod);
	}
	return productList;
    }

    private Integer getPercentage(Product product) {
	BigDecimal discount = new BigDecimal(((product.getRetailPrice() - product.getDiscountedPrice()) / product.getRetailPrice()) * 100).setScale(2, RoundingMode.HALF_UP);
	return discount.intValue();
    }

}
