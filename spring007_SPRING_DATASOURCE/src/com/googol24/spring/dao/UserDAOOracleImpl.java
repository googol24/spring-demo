package com.googol24.spring.dao;

import com.googol24.spring.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDAOOracleImpl implements UserDAO {
    // 集合装配（注入）的属性：sets,lists,maps,arrays
    private Set<String> sets;

    private List<String> lists;

    private Map<String, String> maps;

    private String[] arrays;

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public String[] getArrays() {
        return arrays;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    @Override
    public void save(User user) {
        System.out.println("user" + user + " saved by oracle!");
    }

    @Override
    public String toString() {
        return "list size:" + lists.size() + ", set size:" + sets.size() + ", map size:" + maps.size() + ", array size:" + arrays.length;
    }
}
