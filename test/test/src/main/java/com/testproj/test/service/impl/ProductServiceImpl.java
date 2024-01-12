package com.testproj.test.service.impl;

import com.testproj.test.exceptionHandel.NotFoundException;
import com.testproj.test.mapper.ProductMapper;
import com.testproj.test.model.document.Product;
import com.testproj.test.model.dto.request.ProductRequest;
import com.testproj.test.model.dto.response.ProductResponse;
import com.testproj.test.repository.ProductRepository;
import com.testproj.test.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        log.info("adding product");
    return this.productMapper.productToProductResponse(this.productRepository.save(this.productMapper.ProductRequestToProduct(productRequest)));

    }

    @Override
    public void deleteById(String productId) {
        log.info(String.format("deleting %s product by id ", productId));
         this.productRepository.findById(productId).orElseThrow(()->
               new NotFoundException(String.format("this %s product does not exist",productId)));
        this.productRepository.deleteById(productId);
    }

    @Override
    public ProductResponse  findById(String productId) {
        log.info(String.format("getting %s product by id ", productId));
        Product product=this.productRepository.findById(productId).orElseThrow(()->
                new NotFoundException(String.format("this %s product does not exist",productId)));

          return this.productMapper.productToProductResponse(product);
    }


    @Override
    public ProductResponse updateProductById(ProductRequest productRequest, String productId) {
        log.info(String.format("updating %s product by id ", productId));
        Product product=this.productRepository.findById(productId).orElseThrow(()->
                new NotFoundException(String.format("this %s product does not exist",productId)) );

        product.setProductName(productRequest.getProductName());
        product.setProductPrice(productRequest.getProductPrice());
        return this.productMapper.productToProductResponse(this.productRepository.save(product));
    }


}
