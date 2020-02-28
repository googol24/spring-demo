package com.googol24.spring.dao;

import com.googol24.spring.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("UserDAOMysql")
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

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User user) {
        System.out.println("user" + user + " saved by mysql!");

        try {
            // 存入数据库
            Connection connection = dataSource.getConnection();
            connection.createStatement().executeUpdate("INSERT INTO user(`user_name`) VALUES ('zhangsan')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "daoId:" + daoId + ", daoStatus:" + daoStatus;
    }
}
