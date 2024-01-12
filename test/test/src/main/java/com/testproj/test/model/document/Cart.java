package com.testproj.test.model.document;

import com.testproj.test.model.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Cart_tt")
public class Cart {
    @Id
    private String cartId;
    private String userId;
   // private Integer quantity ;
    private Double totalPrice ;
    private Map<String,Integer> product;
    private CartStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
