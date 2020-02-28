package com.googol24.spring.main;

import com.googol24.spring.model.User;
import com.googol24.spring.service.UserService;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        UserService service = new UserService();

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("abc123");

        service.add(user);
    }
}
