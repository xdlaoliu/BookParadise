package com.jason.bookparadise.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/15.
 */
@Entity
@Table(name="Downloadbook")
public class Downloadbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer userid;
    Integer bookid;
    Date downloadtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getDownloadtime() {
        return downloadtime;
    }

    public void setDownloadtime(Date downloadtime) {
        this.downloadtime = downloadtime;
    }

    @Override
    public String toString() {
        return "Downloadbook{" +
                "id=" + id +
                ", userid=" + userid +
                ", bookid=" + bookid +
                ", downloadtime=" + downloadtime +
                '}';
    }
}
