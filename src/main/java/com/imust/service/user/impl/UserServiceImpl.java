package com.imust.service.user.impl;

import com.imust.dao.user.UserDao;
import com.imust.entity.user.User;
import com.imust.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        System.out.println("service添加");
        userDao.add();
    }
}
