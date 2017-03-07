package com.yc.www.jfinal.model.entity;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Nick on 2017/3/5.
 */
public class User extends Model<User> {
    public static final User dao = new User().dao();

    private int id;
    private String name;
    private String password;
    private String age;
    private String gender;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
