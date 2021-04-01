package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.api.service.UserService;

import javax.annotation.security.PermitAll;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PermitAll
    @GetMapping("/registration")
    public String registrationPage(){
        return "registrationPage";
    }

    @PermitAll
    @PostMapping("/registration")
    public String registration(UserDTO userDto) {
        userService.save(userDto);
        return "redirect:/profile";
    }
}
