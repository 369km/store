package com.fudo.store.service;

import com.fudo.store.model.User;

public interface UserService {
    User save(User user);

    User find(User user);
}
