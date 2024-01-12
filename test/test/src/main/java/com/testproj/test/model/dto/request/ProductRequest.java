package com.testproj.test.model.dto.request;

import com.testproj.test.costumeAnnotations.TrimmedString;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    @NotNull(message = "product name should not be null")
    @NotEmpty(message = "product name should not be empty")
    @NotBlank(message = "product name should not be blank")
    @TrimmedString
    private String productName;
    @Min(value = 1,message = "the min of price is 1")
    private Double productPrice;
}
