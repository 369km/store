package com.fudo.store.controller;

import com.fudo.store.model.User;
import com.fudo.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        User login = userService.login(user, request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(login);
        modelAndView.setViewName("goods");
        return modelAndView;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        userService.logout(request);
    }
}
