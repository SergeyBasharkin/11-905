package ru.kpfu.itis.demo.blog.api.service;

import ru.kpfu.itis.demo.blog.api.dto.SignUpDTO;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;

public interface UserService {

    void signUp(SignUpDTO signUpDTO);

    UserDTO userIsExist(String email);
}
