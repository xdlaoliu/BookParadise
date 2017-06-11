package com.jason.bookparadise.controller;

import com.jason.bookparadise.entities.User;
import com.jason.bookparadise.service.BookService;
import com.jason.bookparadise.service.PwService;
import com.jason.bookparadise.service.RoleService;
import com.jason.bookparadise.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
@RequestMapping("/handleuser")
public class HandleUserController {

    @Autowired
    UserService userService;

    @Autowired
    PwService pwService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value="/add",method= RequestMethod.POST)
    public String addUser(String username,String userpw,String gender,Date birthday,String education,String Hobby,String Motto){
        userService.addUser(username,gender,birthday,education,Hobby,Motto);
        pwService.savePw(username,userpw);
        roleService.addRole(username,"user");
        return "redirect:/Login";
    }

    @RequestMapping(value = "delete")
    public void deleteUser(@RequestParam Integer userid){

    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/Login";
    }

    @RequestMapping("/useredit")
    public String useredit(Map<String,Object> map){
        Integer userid = userService.getcurrentid();
        User user = userService.getUserById(userid);
        System.out.println(user);
        map.put("useredit", user);
        return "useredit";
    }

    @RequestMapping("/update")
    public String updateuser(Integer userid,String username,String gender,Date birthday,String education,String Hobby,String Motto){
        userService.updateUser(userid,username,gender,birthday,education,Hobby,Motto);
        return "redirect:/Myspace";
    }

}
