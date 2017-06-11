package com.jason.bookparadise.service;

import com.jason.bookparadise.dao.RoleDao;
import com.jason.bookparadise.entities.Role;
import com.jason.bookparadise.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public void addRole(String username,String role_name){
        Role role = new Role();
        role.setUsername(username);
        role.setRole_name(role_name);
        roleDao.saveRole(role);
    }

}
