package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.demo.blog.api.dto.SignUpDTO;
import ru.kpfu.itis.demo.blog.impl.service.BlogUserService;
import ru.kpfu.itis.demo.blog.web.form.UserForm;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author Roman Leontev
 * 13:34 02.04.2021
 * group 11-905
 */

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private BlogUserService userService;

    @GetMapping
    public String getLogin(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "sign_up";
    }

    @PostMapping
    public String signUp(@Valid UserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidPasswords")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("userForm", form);
            return "sign_up";
        } else {
            userService.signUp(SignUpDTO.builder()
                    .email(form.getEmail())
                    .password(form.getPassword())
                    .build()
            );
            return "redirect:/login";
        }
    }
}