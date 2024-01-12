package com.testproj.test.mapper;

import com.testproj.test.model.document.Cart;
import com.testproj.test.model.dto.request.CartRequest;
import com.testproj.test.model.dto.response.CartResponse;
import com.testproj.test.model.enums.CartStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CartMapper {
    public Cart CartToCartRequest(CartRequest request){
        return Cart.builder().userId(request.getUserId())
                .status(CartStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
    public CartResponse CartToCartResponse(Cart cart){
       return CartResponse.builder().cartId(cart.getCartId())
                .userId(cart.getUserId())
                .status(cart.getStatus())
                .product(cart.getProduct())
                .totalPrice(cart.getTotalPrice())
               .createdAt(cart.getCreatedAt())
               .updatedAt(cart.getUpdatedAt())
                .build();
    }
}
