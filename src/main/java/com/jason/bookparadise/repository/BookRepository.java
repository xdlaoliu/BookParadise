package com.jason.bookparadise.repository;

import com.jason.bookparadise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface BookRepository extends JpaRepository<Book, Integer>{

    @Query(value="SELECT COUNT(DISTINCT bookid) FROM books",nativeQuery = true)
    Integer findCountBook();

    List<Book> findByPersonid(Integer id);
}
