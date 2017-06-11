package com.jason.bookparadise.dao;

import com.jason.bookparadise.entities.User;
import com.jason.bookparadise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getOne(Integer id){
        return userRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Integer getMaxId(){
        return userRepository.findMaxId();
    }

    @Transactional(readOnly = true)
    public Integer getUserid(String username){
        return userRepository.findUserId(username);
    }

    @Transactional(readOnly = true)
    public User getUserById(Integer id){
        return userRepository.findUserByUserid(id);
    }

    @Transactional
    public void saveuser(User user){
        userRepository.saveAndFlush(user);
    }

    @Transactional
    public void deleteUserByid(Integer userid){
        userRepository.delete(userid);
    }

}
