package com.retailops.service;

import com.retailops.entity.Product;
import com.retailops.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    public void reduceStock(Product product, int quantity) {

        if (product.getStock() < quantity) {
            throw new RuntimeException(
                    "Insufficient stock for product: " + product.getName()
            );
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }
}
