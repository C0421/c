package com.entity;

import java.time.LocalDateTime;

public class User {
    private String id;
    private String name;
    private LocalDateTime insertTime;
    private String userName;
    private String password;

    // 无参构造函数
    public User() {
    }

    // 继承自第一个类的构造函数
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 继承自第一个类的完整构造函数
    public User(String id, String name, LocalDateTime insertTime) {
        this.id = id;
        this.name = name;
        this.insertTime = insertTime;
    }

    // 继承自第二个类的构造函数
    public User(String name) {
        this.name = name;
    }

    // 新增组合构造函数（可选）
    public User(String id, String name, LocalDateTime insertTime, String userName, String password) {
        this.id = id;
        this.name = name;
        this.insertTime = insertTime;
        this.userName = userName;
        this.password = password;
    }

    // 所有属性的Getter和Setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}