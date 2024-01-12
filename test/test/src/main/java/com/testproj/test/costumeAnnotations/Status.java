package com.testproj.test.costumeAnnotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StatusImpl.class)
public @interface Status {
    String message() default "should have either ACTIVE or DELETED";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
