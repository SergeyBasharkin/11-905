package ru.kpfu.itis.demo.blog.api.service;

import ru.kpfu.itis.demo.blog.api.dto.SignUpForm;

public interface SignUpService {
    Boolean signUp(SignUpForm signUpForm);
}
