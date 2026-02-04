package com.retailops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.retailops.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
