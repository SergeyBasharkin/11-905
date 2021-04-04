package ru.kpfu.itis.demo.blog.impl.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.demo.blog.api.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Roman Leontev
 * 00:02 28.02.2021
 * group 11-905
 */

public class UniqEmailValidator implements ConstraintValidator<ValidUniqEmail, String> {

   @Autowired
   private UserService userService;

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return userService.userIsExist(value) == null;
   }
}
