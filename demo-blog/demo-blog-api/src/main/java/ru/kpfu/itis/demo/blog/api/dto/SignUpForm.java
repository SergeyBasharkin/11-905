package ru.kpfu.itis.demo.blog.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpForm {
    private String name;
    private String email;
    private String password;
    private String passwordAgain;
}
