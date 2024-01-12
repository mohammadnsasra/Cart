package com.testproj.test.repository.mongo;

import com.testproj.test.model.document.Cart;
import com.testproj.test.model.enums.CartStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepositoryMongo extends MongoRepository<Cart,String> {
    public Optional<Cart> findByUserIdAndStatus(String userId, CartStatus status);
    public Optional<Cart> findByCartIdAndStatus(String cartId, CartStatus status);
}
