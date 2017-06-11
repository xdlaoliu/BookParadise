package com.jason.bookparadise.entities;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/15.
 */

@Entity
@Table(name="userinfor")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userid;
    String username;
    String gender;
    Date birthday;
    String education;
    String hobby;
    String motto;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", education='" + education + '\'' +
                ", hobby='" + hobby + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }
}
