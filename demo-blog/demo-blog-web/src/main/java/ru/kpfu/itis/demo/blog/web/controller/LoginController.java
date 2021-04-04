package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 * group 11-905
 */
@Controller
public class LoginController {

    @PermitAll
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
