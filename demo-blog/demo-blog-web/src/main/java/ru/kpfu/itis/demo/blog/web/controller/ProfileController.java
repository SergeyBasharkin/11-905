package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.demo.blog.web.security.details.UserDetailsImpl;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        model.addAttribute("user", userDetails);
        return "profile";
    }
}
