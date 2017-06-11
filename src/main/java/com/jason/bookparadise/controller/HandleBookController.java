package com.jason.bookparadise.controller;

import com.jason.bookparadise.dao.BookDao;
import com.jason.bookparadise.entities.Book;
import com.jason.bookparadise.service.BookService;
import com.jason.bookparadise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
@RequestMapping("/handlebook")
public class HandleBookController {

    private final String EditPage = "bookedite";

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/add",method= RequestMethod.POST)
    public String addBook(String bookname,String author,@RequestParam(value="uploadpdf") MultipartFile file){

        bookService.addBook(bookname,author,file);
//        System.out.println(filepath+"/"+userid+"/"+bookname+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        return "redirect:/Myspace";
    }

    @RequestMapping(value="/update",method= RequestMethod.POST)
    public String updateBook(Integer bookid,String bookname,String author,@RequestParam(value="uploadpdf") MultipartFile file){

        if(!bookService.updateBook(bookid, bookname, author, file)){
            return "error";
        }
        if(userService.isAdmin()){
            return "redirect:/Home";
        }
        return "redirect:/Myspace";

    }

    @RequestMapping(value="/edit")
    public String editBook(@RequestParam Integer bookid,Map<String,Object> map){
        Book book = bookService.findBookById(bookid);
        if(userService.isAdmin()){
            map.put("book", book);
            return EditPage;
        }
        if(book==null){
            return "error";
        }
        if(!userService.getcurrentid().equals(book.getPersonid())){
            return "error";
        }
        map.put("book", book);
        return EditPage;
    }

    @RequestMapping(value="/delete")
    public String deleteBook(@RequestParam Integer bookid){

        if(!bookService.deleteBookById(bookid)){
            return "error";
        }
        if(userService.isAdmin()){
            return "redirect:/Home";
        }
        return "redirect:/Myspace";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(@RequestParam Integer bookid) throws IOException {

        try {
            return bookService.DownLoadFile(bookid);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
