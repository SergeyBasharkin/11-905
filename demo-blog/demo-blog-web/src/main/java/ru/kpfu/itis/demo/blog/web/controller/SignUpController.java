package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.demo.blog.api.dto.SignUpForm;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;

@Controller
public class SignUpController {

    private final SignUpService signUpService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(SignUpService signUpService, PasswordEncoder passwordEncoder) {
        this.signUpService = signUpService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpForm form, ModelMap model) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        if (signUpService.signUp(form)) {
            return "redirect:/signIn";
        }
        return "sign_up";
    }
}

