package com.retailops.controller;

import com.retailops.entity.CartItem;
import com.retailops.entity.Order;
import com.retailops.entity.Product;
import com.retailops.repository.CartItemRepository;
import com.retailops.repository.OrderRepository;
import com.retailops.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Place order from cart
    @PostMapping("/checkout")
    public String checkout() {

        List<CartItem> cartItems = cartItemRepository.findAll();

        if (cartItems.isEmpty()) {
            return "Cart is empty";
        }

        for (CartItem item : cartItems) {

            Product product = item.getProduct();

            if (product.getStock() < item.getQuantity()) {
                return "Insufficient stock for product: " + product.getName();
            }

            // Reduce stock
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            // Create order
            Order order = new Order();
            order.setProduct(product);
            order.setQuantity(item.getQuantity());

            orderRepository.save(order);
        }

        // Clear cart
        cartItemRepository.deleteAll();

        return "Order placed successfully";
    }
}
