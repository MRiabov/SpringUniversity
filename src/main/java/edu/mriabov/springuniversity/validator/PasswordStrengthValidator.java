package edu.mriabov.springuniversity.validator;

import edu.mriabov.springuniversity.annotation.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator,String> {

    HashSet<String> weakPasswords=new HashSet<>();

    @Override
    public void initialize(PasswordValidator passwordValidator) {
        weakPasswords.add("123456");
        weakPasswords.add("qwerty");
        weakPasswords.add("password");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return passwordField!=null&&!weakPasswords.contains(passwordField);
    }
}
