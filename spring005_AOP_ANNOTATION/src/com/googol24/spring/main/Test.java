package com.googol24.spring.main;

import com.googol24.spring.model.User;
import com.googol24.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = (UserService) ctx.getBean("userService");
// 检测userService是否为动态代理的实例
// UserService类没有实现接口，其动态代理需要用CGLIB来实现，否则的话用JDK的动态代理(InvocationHandler Proxy)来实现
System.out.println("class of userService: " + userService.getClass());// EnhancerByCGLIB

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin123");

        userService.add(user);
    }
}
