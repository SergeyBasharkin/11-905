package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;
}
