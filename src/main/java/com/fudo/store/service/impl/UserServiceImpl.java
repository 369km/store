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

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

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
    public User login(User user, HttpServletRequest request) {
        User dbUser = userRepo.findOne(Example.of(user,
                ExampleMatcher.matching()
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
                        .withMatcher("password", ExampleMatcher.GenericPropertyMatchers.exact())
                        .withIgnorePaths("createTime")))
                .orElseThrow(() -> new BaseException(BaseEnum.LOGIN_FAIL));
        dbUser.setPassword("");
        redisSetSession(request);
        return dbUser;
    }

    @Override
    public void logout(HttpServletRequest request) {
        stringRedisTemplate.opsForSet().remove("session", request.getSession().getId());
    }

    private void redisSetSession(HttpServletRequest request) {
        Set<String> session = new HashSet<>();
        session.add(request.getSession().getId());
        session.addAll(stringRedisTemplate.opsForSet().members("session"));
        session.forEach(item -> stringRedisTemplate.opsForSet().add("session", item));
    }

}
