package ru.kpfu.itis.demo.blog.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.api.service.UserService;

@Controller
public class SignUpController {
    @Autowired
    private UserService userService;

    @GetMapping("/signUp")
    public String signUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/signIn";
    }
}
