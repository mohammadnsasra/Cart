package com.testproj.test.service;


import com.testproj.test.model.dto.request.CartProductRequest;
import com.testproj.test.model.dto.request.CartRequest;
import com.testproj.test.model.dto.request.CartStatusRequest;
import com.testproj.test.model.dto.response.CartResponse;
import com.testproj.test.model.enums.CartStatus;
import java.util.List;


public interface CartService {
    public CartResponse createCart(CartRequest cartRequest);
    public CartResponse findById(String cartId);
    void deleteCartById(String cartId);
    public CartResponse removeProductFromCart(String cartId,String productId);
    public CartResponse addProductsInCart(String cartId, String productId);
    public CartResponse activationStatus(String cartId);
    public CartResponse updateQuantityByProductId(String cartId, CartProductRequest request);
    public List<CartStatus> getStatus();
    public CartResponse softDeleted(String cartId);
    public CartResponse getCartByUserId(String userId);
    public CartResponse updateStatus(String cartId, CartStatusRequest statusRequest);
}
