package com.googol24.spring.model;

/**
 * 用户账号实体类
 */
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "[name:" + username + ", pass:" + password + "]";
    }
}
