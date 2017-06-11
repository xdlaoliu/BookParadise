package com.jason.bookparadise.controller;

import com.jason.bookparadise.entities.Book;
import com.jason.bookparadise.entities.User;
import com.jason.bookparadise.service.BookService;
import com.jason.bookparadise.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/7.
 */

@Controller
@RequestMapping("/")
public class StaticPageController {

    private final String USERPAGE = "userinfor";
    private final String BOOKPAGE = "bookinfor";
    private final String HOME = "homepage";
    private final String LOGIN = "login";
    private final String ADMINPAGE = "adminpage";
    private final String MYSPACE = "myspace";
    private final String ERROR = "error";

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping("/userpage")
    public String userPage(){
        return USERPAGE;
    }

    @RequestMapping("/bookpage")
    public String bookPage(){
        return BOOKPAGE;
    }

    @RequestMapping("/Home")
    public String homepage(Map<String,Object> map){
        if(SecurityUtils.getSubject().hasRole("admin")){
            List<Book> books = bookService.listAllBooks();
            map.put("books",books);
            List<User> users = userService.getAllUsers();
            map.put("users",users);
            return ADMINPAGE;
        }
        else{
            List<Book> books = bookService.listAllBooks();
            map.put("books",books);
            return HOME;
        }
    }

    @RequestMapping("/Login")
    public String logIn(){
        return LOGIN;
    }

    @RequestMapping("/Myspace")
    public String myspace(Map<String,Object> map){
        Integer userid = userService.getcurrentid();
        List<Book> books = bookService.findBooksByPersonid(userid);
        User user =  userService.getUserById(userid);
        map.put("books",books);
        map.put("user",user);
        return MYSPACE;
    }

    @RequestMapping("/Error")
    public String errorpage(){
        return ERROR;
    }

    @RequestMapping("/Register")
    public String register(){
        return USERPAGE;
    };



}
