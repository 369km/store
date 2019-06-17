package com.fudo.store.service.impl;

import com.fudo.store.model.User;
import com.fudo.store.repository.UserRepo;
import com.fudo.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
