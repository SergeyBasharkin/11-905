package ru.kpfu.itis.demo.blog.impl.form;

import lombok.Data;
import lombok.ToString;
import ru.kpfu.itis.demo.blog.impl.validation.PasswordMatch;
import ru.kpfu.itis.demo.blog.impl.validation.UniqueEmail;

import javax.validation.constraints.NotBlank;

@Data
@ToString
@PasswordMatch(
        message = "password doesn't match",
        password = "password",
        confirmPassword = "confirmPassword"
)
public class UserForm {
    @UniqueEmail
    @NotBlank(message = "email cannot be blank")
    private String email;
    @NotBlank(message = "username cannot be blank")
    private String username;
    @NotBlank(message = "password cannot be blank")
    private String password;
    @NotBlank(message = "please repeat your password")
    private String confirmPassword;
}
