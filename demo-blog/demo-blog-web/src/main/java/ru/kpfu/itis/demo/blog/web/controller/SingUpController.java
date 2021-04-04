package ru.kpfu.itis.demo.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.demo.blog.api.dto.SignUpForm;
import ru.kpfu.itis.demo.blog.api.service.SignUpService;

import javax.annotation.security.PermitAll;

@Controller
public class SingUpController {

    private final SignUpService signUpService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SingUpController(SignUpService signUpService, PasswordEncoder passwordEncoder) {
        this.signUpService = signUpService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signUp")
    public String signUpPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);

        return "sign_up";
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(SignUpForm form, ModelMap model) {
        //TODO заменить на spring validation
        if (!form.getPassword().equals(form.getPasswordAgain())) {
            model.addAttribute("error", "Password don't match");
            return new ModelAndView("redirect:/signUp", model);
        }

        form.setPassword(passwordEncoder.encode(form.getPassword()));

        if (signUpService.signUp(form)) {
            return new ModelAndView("redirect:/signIn", model);
        }

        model.addAttribute("error", "User with this email already exist");
        return new ModelAndView("redirect:/signUp", model);
    }
}
