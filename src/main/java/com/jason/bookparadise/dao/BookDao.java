package com.jason.bookparadise.dao;

import com.jason.bookparadise.entities.Book;
import com.jason.bookparadise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */

@Service
public class BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly=true)
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getById(Integer id){return bookRepository.findOne(id);};

    @Transactional(readOnly = true)
    public List<Book> findByPersonid(Integer id){
        return bookRepository.findByPersonid(id);
    }

    @Transactional
    public void savebook(Book book){
        bookRepository.saveAndFlush(book);
    }

    @Transactional
    public void deletebook(Integer id){
        bookRepository.delete(id);
    }

}
