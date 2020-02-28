package com.googol24.spring.main;

import com.googol24.spring.dao.UserDAO;
import com.googol24.spring.model.User;
import com.googol24.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");

        // @Autowired
        System.out.println("------@Autowired------");
        UserService userService = (UserService) beanFactory.getBean("userService");

        User user = new User();
        user.setUsername("Alice");
        user.setPassword("123456");

        // 注入成功即可调用成功
        userService.add(user);

        // @Resource
        System.out.println("----@Resource------");
        System.out.println(userService.getUserDAOResource());
    }
}
