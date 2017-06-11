package com.jason.bookparadise.service;

import com.jason.bookparadise.dao.PwDao;
import com.jason.bookparadise.entities.Pw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/22.
 */
@Service
public class PwService {

    @Autowired
    PwDao pwDao;

    public void savePw(String username,String userpw){
        Pw pw = new Pw();
        pw.setUsername(username);
        pw.setPassword(userpw);
        pwDao.savepw(pw);
    }

}
