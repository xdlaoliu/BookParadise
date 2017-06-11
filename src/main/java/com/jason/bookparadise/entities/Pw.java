package com.jason.bookparadise.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/22.
 */
@Entity
@Table(name="users")
public class Pw{

    @Id
    String username;
    String password;

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
}
