package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roman Leontev
 * 13:33 02.04.2021
 * group 11-905
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getLogin() {
        return "login";
    }
}
