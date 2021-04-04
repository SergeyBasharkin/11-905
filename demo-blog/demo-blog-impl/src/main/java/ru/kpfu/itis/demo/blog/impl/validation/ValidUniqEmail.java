package ru.kpfu.itis.demo.blog.impl.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Roman Leontev
 * 00:01 28.02.2021
 * group 11-905
 */

@Constraint(validatedBy = UniqEmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUniqEmail {
    String message() default "Mail is not unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}