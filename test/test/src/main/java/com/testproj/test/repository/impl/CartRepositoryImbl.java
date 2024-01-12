package com.testproj.test.repository.impl;

import com.testproj.test.model.document.Cart;
import com.testproj.test.model.enums.CartStatus;
import com.testproj.test.repository.CartRepository;
import com.testproj.test.repository.mongo.CartRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CartRepositoryImbl implements CartRepository {
    @Autowired
    private CartRepositoryMongo cartRepositoryMongo;
    @Override
    public Cart save(Cart cart) {

        return this.cartRepositoryMongo.save(cart);
    }

    @Override
    public Optional<Cart> findByUserIdAndStatus(String userId, CartStatus status) {
        return this.cartRepositoryMongo.findByUserIdAndStatus(userId,status);
    }

    @Override
    public Optional<Cart> findByCartIdAndStatus(String cartId, CartStatus status) {
        return this.cartRepositoryMongo.findByCartIdAndStatus(cartId,status);
    }

    @Override
    public void deleteById(String cartId) {
         this.cartRepositoryMongo.deleteById(cartId);
    }

    @Override
    public Optional<Cart> findById(String cartId) {
        return this.cartRepositoryMongo.findById(cartId);
    }


}
