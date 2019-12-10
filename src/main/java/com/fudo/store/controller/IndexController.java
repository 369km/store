package com.fudo.store.controller;

import com.fudo.store.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String home(User user) {
        return "index";
    }
}
