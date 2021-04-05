package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.impl.service.BlogSignUpService;

import javax.annotation.security.PermitAll;

@Controller
public class SignUpController {

    @Autowired
    private BlogSignUpService signUpService;

    @PermitAll
    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "register";
    }

    @PermitAll
    @PostMapping("signUp")
    public String signUp(UserDTO userDTO) {
        if (signUpService.signUp(userDTO)) {
            return "login";
        }
        return "register";
    }
}
