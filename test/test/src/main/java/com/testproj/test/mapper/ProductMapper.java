package com.testproj.test.mapper;

import com.testproj.test.model.document.Product;
import com.testproj.test.model.dto.request.ProductRequest;
import com.testproj.test.model.dto.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product ProductRequestToProduct(ProductRequest request){
        return Product.builder()
                .productName(request.getProductName())
                .productPrice(request.getProductPrice())
                .build();
    }
    public ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .build();
    }
}
