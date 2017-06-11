package com.jason.bookparadise.service;

import com.jason.bookparadise.dao.PwDao;
import com.jason.bookparadise.dao.RoleDao;
import com.jason.bookparadise.dao.UserDao;
import com.jason.bookparadise.entities.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/19.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    PwDao pwDao;

    public void addUser(String username,String gender,Date birthday,String education,String hobby,String motto){
        User user = new User();
        user.setUsername(username);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setEducation(education);
        user.setHobby(hobby);
        user.setMotto(motto);
        userDao.saveuser(user);
        Integer userid = user.getUserid();
        String filepath = "F:/BookParadise/Files"+userid;
        File folder = new File(filepath);
        if(!folder.exists()){
            folder.mkdir();
        }
    }

    public void deleteUser(Integer userid){

        User user = userDao.getUserById(userid);
        userDao.deleteUserByid(userid);
        roleDao.deleteRole(user.getUsername());
        pwDao.deletePw(user.getUsername());

    }

    public List<User> getAllUsers(){
        return userDao.getAll();
    }

    public Integer getcurrentid(){
        Subject currentUser = SecurityUtils.getSubject();
        String username = (String) currentUser.getPrincipal();
        System.out.println(username);
        return userDao.getUserid(username);
    }

    public boolean isAdmin(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.hasRole("admin");
    }

    public User getUserById(Integer id){
        User user = userDao.getUserById(id);
        return user;
    }

    public Integer getUseridByName(String username){
        return userDao.getUserid(username);
    }

    public void updateUser(Integer id,String username,String gender,Date birthday,String education,String Hobby,String Motto){
        User user = userDao.getUserById(id);
        user.setUsername(username);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setEducation(education);
        user.setHobby(Hobby);
        user.setMotto(Motto);
        userDao.saveuser(user);
    }

}
