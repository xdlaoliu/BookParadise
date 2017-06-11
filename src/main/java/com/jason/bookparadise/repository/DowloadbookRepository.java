package com.jason.bookparadise.repository;

import com.jason.bookparadise.entities.Downloadbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface DowloadbookRepository extends JpaRepository<Downloadbook,Integer>{

    List<Downloadbook> findByUserid(Integer userid);

    List<Downloadbook> findByBookid(Integer bookid);

}
