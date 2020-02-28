package com.googol24.spring.service;

import com.googol24.spring.dao.*;
import com.googol24.spring.model.User;

/**
 * 用户管理类（负责操作用户的业务逻辑）
 */
public class UserService {
    /**
     * 对DAO的引用，可以灵活指定DAO的实现类（用哪种数据库来保存）
     */
    private UserDAO userDAO;
//    private UserDAO userDAO = new UserDAOOracleImpl();

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * 添加用户
     */
    public void add(User user) {
        userDAO.save(user);
    }
}
