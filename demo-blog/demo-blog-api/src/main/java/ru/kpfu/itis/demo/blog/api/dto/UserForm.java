package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String password;
}
