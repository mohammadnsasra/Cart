package com.testproj.test.controller;


import com.testproj.test.model.dto.request.ProductRequest;
import com.testproj.test.model.dto.response.ProductResponse;
import com.testproj.test.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ProductResponse addProduct(@Valid @RequestBody ProductRequest productRequest){
       return this.productService.addProduct(productRequest);
    }
    @GetMapping
    public ProductResponse getProductById(@RequestParam String productId){
        return this.productService.findById(productId);
    }
    @DeleteMapping
    public void deleteProductById(@RequestParam String productId){

        this.productService.deleteById(productId);
    }
    @PutMapping
    public ProductResponse updateProductById(@Valid @RequestBody ProductRequest productRequest,@RequestParam String productId){
        return this.productService.updateProductById(productRequest,productId);
    }

}
