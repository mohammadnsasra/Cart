package com.testproj.test.costumeAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StatusImpl implements ConstraintValidator<Status, String> {
    @Override
    public boolean isValid(String statusCart, ConstraintValidatorContext constraintValidatorContext) {
        return statusCart !=null && (statusCart.equals("ACTIVE") ||  statusCart.equals("DELETED"));
    }
}
