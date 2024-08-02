package be.vdab.validation;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PositiveOrZero;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
//@Constraint(validatedBy = {})
//@PositiveOrZero
//@Digits(integer = 7, fraction = 2)
//@interface Prijs {
//    String message() default "{be.vdab.Prijs.message}";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
@Constraint(validatedBy = PrijsValidator.class)
@interface Prijs {
    String message() default "{be.vdab.Prijs.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
