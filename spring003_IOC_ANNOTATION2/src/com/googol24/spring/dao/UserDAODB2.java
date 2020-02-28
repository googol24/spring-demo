package com.googol24.spring.dao;

import com.googol24.spring.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 声明为组件类，便于Spring容器扫描
 * value = UserDAOComponent
 */
@Component("UserDAOComponent")
public class UserDAODB2 implements UserDAO {
    @Override
    public void save(User user) {
        System.out.println("user" + user + " saved by DB2!");
    }
}
