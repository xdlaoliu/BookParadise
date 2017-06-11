package com.jason.bookparadise.repository;

import com.jason.bookparadise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value="SELECT MAX(userid) FROM users",nativeQuery = true)
    Integer findMaxId();

    @Query(value="SELECT userid FROM userinfor where username=?1",nativeQuery = true)
    Integer findUserId(String username);

    User findUserByUserid(Integer userid);

}
