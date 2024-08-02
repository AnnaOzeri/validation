package be.vdab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = VerkoopPrijsAankoopPrijsValidator.class)
@interface VerkoopPrijsAankoopPrijs {
    String message() default "{be.vdab.VerkoopPrijsAankoopPrijs.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
