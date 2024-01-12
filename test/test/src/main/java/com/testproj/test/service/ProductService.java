package com.testproj.test.service;


import com.testproj.test.model.dto.request.ProductRequest;
import com.testproj.test.model.dto.response.ProductResponse;


public interface ProductService {
    public ProductResponse addProduct(ProductRequest productRequest);
    void deleteById(String productId);
    public ProductResponse findById(String productId);
    public ProductResponse updateProductById(ProductRequest productRequest,String cartId);

}
