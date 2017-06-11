package com.jason.bookparadise.repository;

import com.jason.bookparadise.entities.Userlogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface UserloginRepository extends JpaRepository<Userlogin,Integer>{

    @Query(value="SELECT * FROM userlogin WHERE logintime=(SELECT max(logintime) FROM userlogin WHERE userid=?1)AND userid=?1",nativeQuery = true)
    Userlogin getLatestLoginTime(Integer userid);

}
