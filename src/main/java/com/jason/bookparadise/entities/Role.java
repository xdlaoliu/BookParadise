package com.jason.bookparadise.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name="user_roles")
public class Role {

    @Id
    private String username;
    private String role_name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
