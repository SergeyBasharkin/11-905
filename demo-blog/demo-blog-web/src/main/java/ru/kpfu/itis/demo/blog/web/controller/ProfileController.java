package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    @PermitAll
    @PreAuthorize("isAuthenticated()")
    public String getProfilePage() {
        return "profile";
    }
}
