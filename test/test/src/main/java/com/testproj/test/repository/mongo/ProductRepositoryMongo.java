package com.testproj.test.repository.mongo;

import com.testproj.test.model.document.Cart;
import com.testproj.test.model.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepositoryMongo extends MongoRepository<Product,String> {
    public Double getProductPriceByProductId(String productId);

}
