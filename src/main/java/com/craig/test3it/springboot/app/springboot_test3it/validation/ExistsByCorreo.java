package com.craig.test3it.springboot.app.springboot_test3it.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByCorreoValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByCorreo {

    String message() default "ya está registrado";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
