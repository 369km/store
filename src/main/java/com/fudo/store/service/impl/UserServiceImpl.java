package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.User;
import com.fudo.store.repository.UserRepo;
import com.fudo.store.service.UserService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User login(User user) {
        User dbUser = userRepo.findOne(Example.of(user,
                ExampleMatcher.matching()
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
                        .withMatcher("password", ExampleMatcher.GenericPropertyMatchers.exact())
                        .withIgnorePaths("createTime")))
                .orElseThrow(() -> new BaseException(BaseEnum.LOGIN_FAIL));
        stringRedisTemplate.opsForSet().add("loginNames", user.getName());
        dbUser.setPassword("");
        return dbUser;
    }
}
