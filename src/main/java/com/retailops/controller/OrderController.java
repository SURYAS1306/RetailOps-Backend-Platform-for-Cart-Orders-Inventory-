package com.retailops.controller;

import com.retailops.entity.CartItem;
import com.retailops.entity.Order;
import com.retailops.entity.Product;
import com.retailops.repository.CartItemRepository;
import com.retailops.repository.OrderRepository;
import com.retailops.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    // Get logged-in user's order history
    @GetMapping
    public List<Order> getUserOrders(Authentication authentication) {
        String username = authentication.getName();
        return orderRepository.findByUsername(username);
    }

    // Checkout logged-in user's cart
    @PostMapping("/checkout")
    public String checkout(Authentication authentication) {

        String username = authentication.getName();

        List<CartItem> cartItems = cartItemRepository.findByUsername(username);

        if (cartItems.isEmpty()) {
            return "Cart is empty";
        }

        for (CartItem item : cartItems) {

            Product product = item.getProduct();

            if (product.getStock() < item.getQuantity()) {
                return "Insufficient stock for product: " + product.getName();
            }

            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            Order order = new Order();
            order.setUsername(username);
            order.setProduct(product);
            order.setQuantity(item.getQuantity());
            order.setOrderTime(LocalDateTime.now());

            orderRepository.save(order);
        }

        cartItemRepository.deleteAll(cartItems);

        return "Order placed successfully";
    }
}
