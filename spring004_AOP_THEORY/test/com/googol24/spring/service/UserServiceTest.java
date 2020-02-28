package com.googol24.spring.service;

import com.googol24.spring.aop.LogInterceptor;
import com.googol24.spring.config.BeanFactory;
import com.googol24.spring.config.ClassPathXmlApplicationContext;
import com.googol24.spring.dao.UserDAO;
import com.googol24.spring.dao.UserDAOMySQLImpl;
import com.googol24.spring.model.User;
import org.junit.Test;

import java.lang.reflect.Proxy;

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

    @Test
    public void testProxy() {
        UserDAO userDAO = new UserDAOMySQLImpl();

        LogInterceptor logInterceptor = new LogInterceptor();

        logInterceptor.setTarget(userDAO);

        // proxy为动态代理类（com.sun.proxy.$Proxy2）的对象，
        UserDAO proxy = (UserDAO) Proxy.newProxyInstance(
                userDAO.getClass().getClassLoader(),
                userDAO.getClass().getInterfaces(),
                logInterceptor
        );

        User u = new User();
        u.setPassword("admin123");
        u.setUsername("admin");

        proxy.save(u);
    }
}