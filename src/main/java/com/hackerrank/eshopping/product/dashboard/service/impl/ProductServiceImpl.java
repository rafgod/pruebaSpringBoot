package com.hackerrank.eshopping.product.dashboard.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.eshopping.product.dashboard.DTO.ProductDTO;
import com.hackerrank.eshopping.product.dashboard.DTO.UpdateProductRequestDTO;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repositories.ProductRepository;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import com.hackerrank.eshopping.product.dashboard.utils.ProductHelper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductHelper productHelper;

    @Override
    public Boolean addProduct(ProductDTO product) {

	try {
	    Optional<Product> prod = productRepository.findById(product.getId());
	    if (!prod.isPresent()) {
		productRepository.save(productHelper.dtoToEntity(product));
		return true;
	    }
	} catch (Exception e) {
	    System.out.println("ProductServiceImpl - ERROR:" + e);
	}

	return false;

    }

    @Override
    public Boolean updateProduct(Long productId, UpdateProductRequestDTO request) {
	try {
	    Optional<Product> prod = productRepository.findById(productId);
	    if (prod.isPresent()) {
		productRepository.save(productHelper.dtoToEntity(request, prod.get()));
		return true;
	    }
	} catch (Exception e) {
	    System.out.println("ProductServiceImpl - ERROR:" + e);
	}

	return false;

    }

    @Override
    public ProductDTO getProductById(Long productId) {
	try {
	    Optional<Product> prod = productRepository.findById(productId);
	    if (prod.isPresent()) {
		return productHelper.entityToDTO(prod.get());
	    }
	} catch (Exception e) {
	    System.out.println("ProductServiceImpl - ERROR:" + e);
	}

	return null;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
	List<ProductDTO> result = new ArrayList<>();
	try {
	    result = productHelper.entityToDTO(productRepository.findByCategoryOrderByAvailabilityDescDiscountedPriceAscIdAsc(category));

	} catch (Exception e) {
	    System.out.println("ProductServiceImpl - ERROR:" + e);
	}

	return result;
    }

    @Override
    public List<ProductDTO> getProductsByCategoryAndAvailability(String category, int availability) {
	List<ProductDTO> result = new ArrayList<>();
	try {
	    result = productHelper.entityToDTODiscount(productRepository.findByCategoryAndAvailability(category, availability == 1));
	    Collections.sort(result, (a, b) -> {
		if (b.getDiscountPercentage().compareTo(a.getDiscountPercentage()) == 0) {
		    if (a.getDiscounted_price().compareTo(b.getDiscounted_price()) == 0) {
			return a.getId().compareTo(b.getId());
		    } else {
			return a.getDiscounted_price().compareTo(b.getDiscounted_price());
		    }
		} else {
		    return b.getDiscountPercentage().compareTo(a.getDiscountPercentage());
		}

	    });
	} catch (Exception e) {
	    System.out.println("ProductServiceImpl - ERROR:" + e);
	}
	return result;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
	List<ProductDTO> result = new ArrayList<>();
	try {
	    result = productHelper.entityToDTO(productRepository.findByOrderByIdAsc());

	} catch (Exception e) {
	    System.out.println("ProductServiceImpl - ERROR:" + e);
	}

	return result;
    }

}
