package com.googol24.spring.dao;

import com.googol24.spring.model.User;

/**
 * 直接操作用户数据库的类
 */
//public class UserDAO {

/**
 * 接口
 * 好处：灵活性，比如这里可以对具体用哪种数据库来实现保存可以灵活挑选（根据不同的实现类）
 */
public interface UserDAO {
    public void save(User user);
}
