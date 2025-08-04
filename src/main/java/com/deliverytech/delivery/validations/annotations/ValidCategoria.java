package com.deliverytech.delivery.validations.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import com.deliverytech.delivery.validations.CategoriaValidator;

@Documented
@Constraint(validatedBy = CategoriaValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCategoria {
    String message() default "Categoria deve ser uma das opções válidas";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}