package com.retailops.controller;

import com.retailops.entity.Order;
import com.retailops.repository.OrderRepository;
import com.retailops.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // Total Orders
    @GetMapping("/stats/orders")
    public Map<String, Long> getTotalOrders() {

        long totalOrders = orderRepository.count();

        Map<String, Long> response = new HashMap<>();
        response.put("totalOrders", totalOrders);

        return response;
    }

    // Total Products
    @GetMapping("/stats/products")
    public Map<String, Long> getTotalProducts() {

        long totalProducts = productRepository.count();

        Map<String, Long> response = new HashMap<>();
        response.put("totalProducts", totalProducts);

        return response;
    }

    // Revenue Calculation
    @GetMapping("/stats/revenue")
    public Map<String, Double> getTotalRevenue() {

        List<Order> orders = orderRepository.findAll();

        double revenue = orders.stream()
                .mapToDouble(o -> o.getProduct().getPrice() * o.getQuantity())
                .sum();

        Map<String, Double> response = new HashMap<>();
        response.put("totalRevenue", revenue);

        return response;
    }
}
