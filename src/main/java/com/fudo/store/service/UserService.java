package com.fudo.store.service;

import com.fudo.store.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User save(User user);

    User login(User user, HttpServletRequest request);

    void logout(HttpServletRequest request);
}
