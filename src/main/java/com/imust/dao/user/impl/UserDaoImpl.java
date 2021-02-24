package com.imust.dao.user.impl;

import com.imust.dao.user.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao添加");
    }
}
