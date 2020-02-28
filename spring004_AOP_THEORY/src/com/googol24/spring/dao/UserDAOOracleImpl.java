package com.googol24.spring.dao;

import com.googol24.spring.model.User;

public class UserDAOOracleImpl implements UserDAO {
    @Override
    public void save(User user) {
        System.out.println("user" + user + " saved by oracle!");
    }
}
