package com.deliverytech.delivery.validations.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import com.deliverytech.delivery.validations.CEPValidator;

@Documented
@Constraint(validatedBy = CEPValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCEP {
    String message() default "CEP deve ter formato válido (00000-000 ou 00000000)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
