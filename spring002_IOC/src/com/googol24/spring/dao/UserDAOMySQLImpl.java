package com.googol24.spring.dao;

import com.googol24.spring.model.User;

public class UserDAOMySQLImpl implements UserDAO {
    // 简单属性注入的属性：daoId, daoStatus
    private int daoId;

    private String daoStatus;

    public int getDaoId() {
        return daoId;
    }

    public void setDaoId(int daoId) {
        this.daoId = daoId;
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    @Override
    public void save(User user) {
        System.out.println("user" + user + " saved by mysql!");
    }

    @Override
    public String toString() {
        return "daoId:" + daoId + ", daoStatus:" + daoStatus;
    }
}
