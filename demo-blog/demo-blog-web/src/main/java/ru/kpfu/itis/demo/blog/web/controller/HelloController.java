package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping
    @PermitAll
    public String hello(Model model){
        model.addAttribute("hello", "World");
        return "hello";
    }

}
