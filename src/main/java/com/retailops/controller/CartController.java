package com.retailops.controller;

import com.retailops.entity.CartItem;
import com.retailops.entity.Product;
import com.retailops.repository.CartItemRepository;
import com.retailops.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    // Get all cart items
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    // Add item to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long productId,
                              @RequestParam int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartItemRepository.save(cartItem);
    }

    // Remove item from cart
    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {

        cartItemRepository.deleteById(id);
        return "Item removed from cart";
    }
}
