package ru.kpfu.itis.demo.blog.impl.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValidator implements ConstraintValidator<ValidPasswords, Object> {

    private String passwordPropertyName;
    private String confirmPasswordPropertyName;

    @Override
    public void initialize(ValidPasswords constraintAnnotation) {
        this.passwordPropertyName = constraintAnnotation.password();
        this.confirmPasswordPropertyName = constraintAnnotation.confirmPassword();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object password = new BeanWrapperImpl(value).getPropertyValue(passwordPropertyName);
        Object confirmPassword = new BeanWrapperImpl(value).getPropertyValue(confirmPasswordPropertyName);

        return password != null && password.equals(confirmPassword);
    }
}
