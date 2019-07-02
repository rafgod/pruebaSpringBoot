package com.hackerrank.eshopping.product.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryOrderByAvailabilityDescDiscountedPriceAscIdAsc(String category);

    List<Product> findByCategoryAndAvailability(String category, Boolean availability);

    List<Product> findByOrderByIdAsc();

}
