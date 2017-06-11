package com.jason.bookparadise.dao;

import com.jason.bookparadise.entities.Downloadbook;
import com.jason.bookparadise.repository.DowloadbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class DownloadbookDao {

    @Autowired
    DowloadbookRepository downloadbookRepository;

    @Transactional(readOnly = true)
    public List<Downloadbook> getDownloadbookByUserid(Integer userid){
        return downloadbookRepository.findByUserid(userid);
    }

    @Transactional(readOnly = true)
    public List<Downloadbook> getDownloadbookByBookid(Integer bookid){
        return downloadbookRepository.findByBookid(bookid);
    }

    @Transactional
    public void saveDownloadBook(Downloadbook downloadbook){
        downloadbookRepository.saveAndFlush(downloadbook);
    }

}
