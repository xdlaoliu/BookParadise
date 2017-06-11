package com.jason.bookparadise.service;

import com.jason.bookparadise.dao.DownloadbookDao;
import com.jason.bookparadise.dao.UserloginDao;
import com.jason.bookparadise.entities.Downloadbook;
import com.jason.bookparadise.entities.Userlogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class LogService {

    @Autowired
    DownloadbookDao downloadbookDao;

    @Autowired
    UserloginDao userloginDao;

    public void updateDownloadbook(Integer userid,Integer bookid){
        Downloadbook downloadbook = new Downloadbook();
        downloadbook.setBookid(bookid);
        downloadbook.setUserid(userid);
        downloadbook.setDownloadtime(new Date());
        downloadbookDao.saveDownloadBook(downloadbook);
    }

    public void updateUserLogin(Integer userid){
        Userlogin userlogin = new Userlogin();
        userlogin.setUserid(userid);
        userlogin.setLogintime(new Date());
        userloginDao.saveUserlogin(userlogin);
    }

}
