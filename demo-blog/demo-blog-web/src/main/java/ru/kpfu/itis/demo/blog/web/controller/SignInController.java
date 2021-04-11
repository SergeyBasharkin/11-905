package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.demo.blog.web.security.provider.JwtAuthenticationProvider;

@Controller
public class SignInController {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public SignInController(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "signIn";
    }


    @ResponseBody
    @PostMapping("/login")
    public String login(String login, String password){

        return jwtAuthenticationProvider.createToken(login);
    }
}
