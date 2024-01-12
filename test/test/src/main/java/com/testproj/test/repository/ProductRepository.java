package com.testproj.test.repository;

import com.testproj.test.model.document.Cart;
import com.testproj.test.model.document.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    public Product save(Product product);
    void deleteById(String productId);
    public Optional<Product> findById(String productId);

    public Double getProductPriceByProductId(String productId);



}
