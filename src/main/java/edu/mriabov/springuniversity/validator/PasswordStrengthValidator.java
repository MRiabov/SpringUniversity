package edu.mriabov.springuniversity.validator;

import edu.mriabov.springuniversity.annotation.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator,String> {

    HashSet<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator passwordValidator) {
        weakPasswords.addAll(Arrays.asList("123456","password","qwerty"));
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return passwordField!=null&&!weakPasswords.contains(passwordField);
    }
}
