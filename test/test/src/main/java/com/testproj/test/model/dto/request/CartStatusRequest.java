package com.testproj.test.model.dto.request;

import com.testproj.test.costumeAnnotations.Status;
import com.testproj.test.costumeAnnotations.TrimmedString;
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
public class CartStatusRequest {
   @NotNull(message = "CartStatus is required")
   @NotEmpty(message = "CartStatus should not be empty")
   @NotBlank(message = "CartStatus should not be blank")
   @Status(message = "you should enter ACTIVE or DELETED ")
   @TrimmedString
    private String cartStatus;
}
