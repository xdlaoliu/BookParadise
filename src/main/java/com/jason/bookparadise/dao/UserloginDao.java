package com.jason.bookparadise.dao;

import com.jason.bookparadise.entities.Downloadbook;
import com.jason.bookparadise.entities.User;
import com.jason.bookparadise.entities.Userlogin;
import com.jason.bookparadise.repository.UserRepository;
import com.jason.bookparadise.repository.UserloginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class UserloginDao {

    @Autowired
    UserloginRepository userloginRepository;

    Userlogin getLatestLogin(Integer userid){
        Userlogin userlogin = userloginRepository.getLatestLoginTime(userid);
        return userlogin;
    }

    @Transactional
    public void saveUserlogin(Userlogin userlogin){
        userloginRepository.saveAndFlush(userlogin);
    }

}
