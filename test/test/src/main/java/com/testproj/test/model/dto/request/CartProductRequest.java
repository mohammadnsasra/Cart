package com.testproj.test.model.dto.request;

import com.testproj.test.costumeAnnotations.TrimmedString;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CartProductRequest {
    @NotEmpty(message = "the product id is required")
    @NotBlank(message = "the product id should not be blank'")
    @NotNull(message = "the product id should not be null")
    @TrimmedString
    private String productId;
    @NotNull(message = "the quantity of product is required")
    @Min(value = 1,message = "you should choose number > 0 ")
    private Integer quantity;
}
