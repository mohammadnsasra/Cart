package com.testproj.test.repository.impl;

import com.testproj.test.exceptionHandel.NotFoundException;
import com.testproj.test.model.document.Cart;
import com.testproj.test.model.document.Product;
import com.testproj.test.repository.ProductRepository;
import com.testproj.test.repository.mongo.ProductRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private ProductRepositoryMongo productRepositoryMongo;
    @Override
    public Product save(Product product) {
        return this.productRepositoryMongo.save(product);
    }

    @Override
    public void deleteById(String productId) {
     this.productRepositoryMongo.deleteById(productId);
    }

    @Override
    public Optional<Product> findById(String productId) {
        return this.productRepositoryMongo.findById(productId);
    }

    public Double getProductPriceByProductId(String productId){
       return this.productRepositoryMongo.findById(productId).orElseThrow(()->
               new NotFoundException(String.format("this product does not exist",productId))).getProductPrice();
   }


}
