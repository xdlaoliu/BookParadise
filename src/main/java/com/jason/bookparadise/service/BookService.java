package com.jason.bookparadise.service;

import com.jason.bookparadise.dao.BookDao;
import com.jason.bookparadise.entities.Book;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    UserService userService;

    String filepath = "F:/BookParadise/Files";

    public void addBook(String bookname,String author,MultipartFile file){
        Integer userid = userService.getcurrentid();
        String filetype = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        Book book = new Book();
        book.setBookname(bookname);
        book.setPersonid(userid);
        book.setAuthor(author);
        book.setUploaddate(new Date());
        book.setFiletype(filetype);
        bookDao.savebook(book);
        Integer bookid = book.getBookid();
//        System.out.println(bookid);
        try {
            file.transferTo(new File(filepath+"/"+book.getBookid()+"."+filetype));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Book findBookById(Integer id){
        return bookDao.getById(id);
    }

    public boolean deleteBookById(Integer id){
        Integer currentuserid = userService.getcurrentid();
        Book book = bookDao.getById(id);
        if(userService.isAdmin()){
            bookDao.deletebook(id);
            File file = new File(filepath+"/"+book.getBookid()+"."+book.getFiletype());
            // 路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            return true;
        }
        if(book==null){
            return false;
        }
        if(!currentuserid.equals(book.getPersonid())){
            return false;
        }
        bookDao.deletebook(id);
        File file = new File(filepath+"/"+book.getBookid()+"."+book.getFiletype());
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
        return true;
    }

    public boolean updateBook(Integer id,String bookname,String author,MultipartFile file){
        Integer currentuserid = userService.getcurrentid();
        Book book = bookDao.getById(id);
        if(userService.isAdmin()){
            book.setBookname(bookname);
            book.setAuthor(author);
            book.setUploaddate(new Date());
            if(file!=null && file.getSize()!=0){
                new File(filepath+"/"+book.getBookid()+"."+book.getFiletype()).delete();
                String filetype = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                book.setFiletype(filetype);
                try {
                    file.transferTo(new File(filepath+"/"+book.getBookid()+"."+filetype));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bookDao.savebook(book);
            return true;
        }
        if(book==null){
            return false;
        }
        if(!currentuserid.equals(book.getPersonid())){
            return false;
        }
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setUploaddate(new Date());
        if(file!=null && file.getSize()!=0){
            new File(filepath+"/"+book.getBookid()+"."+book.getFiletype()).delete();
            String filetype = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            book.setFiletype(filetype);
            try {
                file.transferTo(new File(filepath+"/"+book.getBookid()+"."+filetype));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bookDao.savebook(book);
        return true;
    }

    public List<Book> findBooksByPersonid(Integer id){
        return bookDao.findByPersonid(id);
    }

    public List<Book> listAllBooks(){return bookDao.getAll();}

    public ResponseEntity<byte[]> DownLoadFile(Integer fileid) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        Book book = bookDao.getById(fileid);
        File file = new File(filepath+"/"+fileid+"."+book.getFiletype());
        String fileName = new String((book.getBookname()+"."+book.getFiletype()).getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
