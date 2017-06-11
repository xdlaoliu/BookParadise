package com.jason.bookparadise.dao;

import com.jason.bookparadise.entities.Book;
import com.jason.bookparadise.entities.Pw;
import com.jason.bookparadise.repository.PwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/11/22.
 */
@Service
public class PwDao {

    @Autowired
    PwRepository pwRepository;

    @Transactional
    public void savepw(Pw pw){
        pwRepository.saveAndFlush(pw);
    }

    @Transactional
    public void deletePw(String username){
        pwRepository.delete(username);
    }

}
