package ru.kpfu.itis.demo.blog.web.form;

import lombok.Data;
import ru.kpfu.itis.demo.blog.impl.validation.ValidPasswords;
import ru.kpfu.itis.demo.blog.impl.validation.ValidUniqEmail;

import javax.validation.constraints.Email;

/**
 * @author Roman Leontev
 * 17:16 02.04.2021
 * group 11-905
 */

@Data
@ValidPasswords(
        message = "{errors.invalid.passwords}",
        password = "password",
        confirmPassword = "confirmPassword"
)
public class UserForm {

    @Email(message = "{errors.incorrect.email}")
    @ValidUniqEmail(message = "{errors.repeated.email}")
    private String email;

    private String password;

    private String confirmPassword;
}
