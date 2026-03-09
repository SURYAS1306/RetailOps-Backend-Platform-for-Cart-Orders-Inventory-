package com.retailops.service;

import com.retailops.entity.Product;
import com.retailops.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryLogRepository inventoryLogRepository;

    public void reduceStock(Product product, int quantity) {

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
        
        InventoryLog log = new InventoryLog();
        log.setProductName(product.getName());
        log.setQuantityChanged(quantity);
        log.setAction("STOCK_DECREASE");
        log.setTimestamp(LocalDateTime.now());
        
        inventoryLogRepository.save(log);
    }
}
