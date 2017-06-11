package com.jason.bookparadise.controller;

import com.jason.bookparadise.service.TestService;
import com.jason.bookparadise.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2016/11/3.
 */
@Controller
@RequestMapping("/Test")
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @RequestMapping("/Page")
    public String test(){
        testService.testit();
        return "test";
    }

    @RequestMapping(value="/adduser",method=RequestMethod.POST)
    public String testAddUser(
            @RequestParam(value="username") String username,
            @RequestParam(value="gender") String gender
            ){
        System.out.println(username);
        System.out.println(gender);
        return "test";
    }

    @RequestMapping(value="/addbook",method=RequestMethod.POST)
    public String testAddBook(
            @RequestParam(value="bookname") String bookname,
            @RequestParam(value="description") String description,
            @RequestParam(value="uploadpdf") MultipartFile file
    ){
        System.out.println(bookname);
        System.out.println(description);
        System.out.println(file.getOriginalFilename());
        return "test";
    }

    @RequestMapping(value="/getid")
    public String testgetid(){
        System.out.println(userService.getcurrentid());
        return "test";
    }

}
