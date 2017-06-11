package com.jason.bookparadise.aspect;

import com.jason.bookparadise.dao.UserDao;
import com.jason.bookparadise.entities.Userlogin;
import com.jason.bookparadise.service.LogService;
import com.jason.bookparadise.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/15.
 */
@Aspect
public class LogAspect {

    private static Log logger = LogFactory.getLog("edit_delete_log");

    @Autowired
    LogService logService;

    @Autowired
    UserService userService;

    @After("execution(* com.jason.bookparadise.service.BookService.DownLoadFile(..)) && args(bookid)")
    public void downloadlog(Integer bookid){
        logService.updateDownloadbook(userService.getcurrentid(),bookid);
    }

    @AfterReturning(returning = "rvt",pointcut = "execution(* org.apache.shiro.mgt.DefaultSecurityManager.login(..))")
    public void loginlog(Subject rvt){
        System.out.println("Log Login Successfully");
        String username = (String) rvt.getPrincipal();
        Integer userid = userService.getUseridByName(username);
        logService.updateUserLogin(userid);
    }

    @After("execution(* com.jason.bookparadise.service.BookService.updateBook(..)) && args(id,bookname,author,file)")
    public void editlog(Integer id,String bookname,String author,MultipartFile file){
        Integer userid = userService.getcurrentid();
        logger.info(id + " Edit Book to Bookname: " + bookname + " Author: " + author + " Orginal filename: " + file.getOriginalFilename());
    }

    @AfterReturning(returning = "rvt", pointcut = "execution(* com.jason.bookparadise.service.BookService.deleteBookById(..)) && args(bookid)")
    public void deletelog(boolean rvt,Integer bookid){
        Integer userid = userService.getcurrentid();
        logger.info(userid + " delete Book" + bookid + " " + rvt);
    }
}
