package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UsersRepository userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UsersRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("users/register")
    public String showRegisterForm (Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("users/register")
    public String submitRegisterForm (@Valid User user, Errors notValid, Model model) {
        if (notValid.hasErrors()) {
            model.addAttribute(notValid);
            model.addAttribute(user);
            return "users/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return "redirect:/login";
    }

}
