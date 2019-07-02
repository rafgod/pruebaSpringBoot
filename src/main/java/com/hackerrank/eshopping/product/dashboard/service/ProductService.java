package com.hackerrank.eshopping.product.dashboard.service;

import java.util.List;

import com.hackerrank.eshopping.product.dashboard.DTO.ProductDTO;
import com.hackerrank.eshopping.product.dashboard.DTO.UpdateProductRequestDTO;

public interface ProductService {

    /*
     * @return true if the product was created, false if the product already exist
     * or occurred and exception
     */
    Boolean addProduct(ProductDTO product);

    /*
     * @return true if the product was updated, false if the product does't exist or
     * occurred and exception
     */
    Boolean updateProduct(Long productId, UpdateProductRequestDTO request);

    ProductDTO getProductById(Long productId);

    List<ProductDTO> getProductsByCategory(String category);

    List<ProductDTO> getProductsByCategoryAndAvailability(String category, int availability);

    List<ProductDTO> getAllProducts();

}
