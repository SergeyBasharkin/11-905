package ru.kpfu.itis.demo.blog.api.form;

import lombok.Data;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 * group 11-905
 */
@Data
public class UserForm {
    private String name;
    private String email;
    private String password;
}
