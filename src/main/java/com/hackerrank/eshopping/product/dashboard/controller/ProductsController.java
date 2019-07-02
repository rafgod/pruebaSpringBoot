package com.hackerrank.eshopping.product.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.eshopping.product.dashboard.DTO.ProductDTO;
import com.hackerrank.eshopping.product.dashboard.DTO.UpdateProductRequestDTO;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO product) {
	return new ResponseEntity<Void>(productService.addProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{product_id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@PathVariable(value = "product_id") Long productId, @RequestBody UpdateProductRequestDTO request) {
	return new ResponseEntity<Void>(productService.updateProduct(productId, request) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{product_id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "product_id") Long productId) {
	ProductDTO product = productService.getProductById(productId);
	return new ResponseEntity<ProductDTO>(product, product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(params = { "category" }, method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getProductByCategory(@RequestParam("category") String category) {
	return new ResponseEntity<List<ProductDTO>>(productService.getProductsByCategory(category), HttpStatus.OK);
    }

    @RequestMapping(params = { "category", "availability" }, method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getProductByCategoryAndAvailability(@RequestParam("category") String category, @RequestParam("availability") int availability) {
	return new ResponseEntity<List<ProductDTO>>(productService.getProductsByCategoryAndAvailability(category.replace("%20", " "), availability), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
	return new ResponseEntity<List<ProductDTO>>(productService.getAllProducts(), HttpStatus.OK);
    }

}
