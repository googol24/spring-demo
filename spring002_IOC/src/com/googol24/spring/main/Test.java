package com.googol24.spring.main;

import com.googol24.spring.dao.UserDAO;
import com.googol24.spring.dao.UserDAOOracleImpl;
import com.googol24.spring.model.User;
import com.googol24.spring.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 从配置文件实例化UserService，不需要在这里new
//        UserService service = new UserService();

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");

        // 从配置文件实例化UserService
        UserService service = (UserService) beanFactory.getBean("userService");

        System.out.println("------从配置文件实例化bean(IOC)------");

        // 从XML配置中读取Bean配置
        UserDAO dao = (UserDAO) beanFactory.getBean("u");

        // 依赖注入方式之setters干的事
//        service.setUserDAO(dao);

        User u = new User();
        u.setPassword("admin123");
        u.setUsername("administrator");

        service.add(u);

        // 简单属性注入
        System.out.println("------简单属性注入------");
        UserDAO dao2 = (UserDAO) beanFactory.getBean("userDAO1");
        System.out.println(dao2);

        // Bean scope
        System.out.println("------Bean scope------");
        UserService service1 = (UserService) beanFactory.getBean("scopeBean1");
        UserService service2 = (UserService) beanFactory.getBean("scopeBean1");
        System.out.println(service1 == service2 ? "service1 == service2" : "service1 != service2");

        UserService service3 = (UserService) beanFactory.getBean("scopeBean2");
        UserService service4 = (UserService) beanFactory.getBean("scopeBean2");
        System.out.println(service3 == service4 ? "service3 == service4" : "service3 != service4");

        // 集合注入（集合装配）
        System.out.println("------集合注入------");
        UserDAO cib = (UserDAO) beanFactory.getBean("collectionInjectionBean");
        System.out.println(cib);

        // Autowire 自动装配
        System.out.println("------自动装配------");
        UserService serviceAutowired = (UserService) beanFactory.getBean("userServiceAutowired");
        System.out.println(serviceAutowired.getUserDAO());

        // 生命周期
        System.out.println("------生命周期------");
        UserService serviceLifeCycle = (UserService) beanFactory.getBean("lifeCycleBean");
        UserService serviceLifeCycle2 = (UserService) beanFactory.getBean("lifeCycleBean");
        beanFactory.destroy();
    }
}
