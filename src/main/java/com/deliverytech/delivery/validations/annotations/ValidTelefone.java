package com.deliverytech.delivery.validations.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import com.deliverytech.delivery.validations.TelefoneValidator;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTelefone {
    String message() default "Telefone deve ter formato válido (10 ou 11 digitos)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
