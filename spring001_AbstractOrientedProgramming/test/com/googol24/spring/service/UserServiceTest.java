package com.googol24.spring.service;

import com.googol24.spring.config.BeanFactory;
import com.googol24.spring.config.ClassPathXmlApplicationContext;
import com.googol24.spring.dao.UserDAO;
import com.googol24.spring.model.User;

public class UserServiceTest {
    @org.junit.Test
    public void add() throws Exception {
        // 从配置文件实例化UserService
//        UserService service = new UserService();


        BeanFactory beanFactory = new ClassPathXmlApplicationContext();

        // 从配置文件实例化UserService
        UserService service = (UserService) beanFactory.getBean("userService");

        // 从XML配置中读取Bean配置
        UserDAO dao = (UserDAO) beanFactory.getBean("u");

        service.setUserDAO(dao);

        User u = new User();
        u.setPassword("admin123");
        u.setUsername("administrator");

        service.add(u);
    }
}