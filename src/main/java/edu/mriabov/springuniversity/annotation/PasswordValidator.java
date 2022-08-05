package edu.mriabov.springuniversity.annotation;

import edu.mriabov.springuniversity.validator.PasswordStrengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    String message() default "Please choose a strong password";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
