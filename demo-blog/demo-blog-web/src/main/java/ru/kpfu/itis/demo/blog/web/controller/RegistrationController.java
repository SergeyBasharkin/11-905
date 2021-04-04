package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.demo.blog.api.form.UserForm;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;

import javax.annotation.security.PermitAll;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 * group 11-905
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private SignUpService signUpService;

    @PermitAll
    @GetMapping
    public String getRegistrationPage() {
        return "registration";
    }

    @PermitAll
    @PostMapping
    public String registration(UserForm form) {
        signUpService.register(form);
        return "redirect:/login";
    }
}

