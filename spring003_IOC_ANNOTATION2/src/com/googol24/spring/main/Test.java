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


        // @Resource
        System.out.println("----@Component------");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin123");

        userService.add(user);

        // @Scope test
        UserService userService2 = (UserService) ctx.getBean("userService");
        System.out.println(userService == userService2);

        // destroy the context
        ctx.destroy();
    }
}
