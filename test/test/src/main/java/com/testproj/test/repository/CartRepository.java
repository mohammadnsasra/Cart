package com.testproj.test.repository;

import com.testproj.test.model.document.Cart;
import com.testproj.test.model.enums.CartStatus;

import java.util.Optional;

public interface CartRepository {
    public Cart save(Cart cart);
    public Optional<Cart> findByUserIdAndStatus(String userId, CartStatus status);
    public Optional<Cart> findByCartIdAndStatus(String cartId, CartStatus status);
    void deleteById(String cartId);
    public Optional<Cart> findById(String cartId);
}
