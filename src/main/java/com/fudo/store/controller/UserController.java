package com.fudo.store.controller;

import com.fudo.store.model.User;
import com.fudo.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Object save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/login")
    public Object login(@ModelAttribute User user, HttpServletRequest request) {
        return userService.login(user, request);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        userService.logout(request);
    }
}
