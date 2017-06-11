package com.jason.bookparadise.entities;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/15.
 */
@Entity
@Table(name="Userlogin")
public class Userlogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer userid;
    Date logintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return "Userlogin{" +
                "id=" + id +
                ", userid=" + userid +
                ", logintime=" + logintime +
                '}';
    }
}
