package com.testproj.test.costumeAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimmedStringValidator implements ConstraintValidator<TrimmedString, String> {
    @Override
    public void initialize(TrimmedString constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        String trimmedValue = value.trim();
        return trimmedValue.equals(value);
    }
}
