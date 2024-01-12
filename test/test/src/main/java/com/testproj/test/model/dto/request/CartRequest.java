package com.testproj.test.model.dto.request;

import com.testproj.test.costumeAnnotations.TrimmedString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequest {
@NotEmpty(message = "the user id is required")
@NotBlank(message = "the user id should not be blank'")
@NotNull(message = "the user id should not be null")
@TrimmedString
    private String userId;

}
