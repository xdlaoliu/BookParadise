package com.jason.bookparadise.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/15.
 */

@Entity
@Table(name="bookinfor")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookid;
    String bookname;
    Integer personid;
    String author;
    Date uploaddate;
    String filetype;

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", personid=" + personid +
                ", author='" + author + '\'' +
                ", uploaddate=" + uploaddate +
                '}';
    }
}
