package com.testproj.test.model.dto.response;

import com.testproj.test.model.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {
    private String cartId;
    private String userId;
    private Double totalPrice ;
    private Map<String,Integer> product;
    private CartStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
