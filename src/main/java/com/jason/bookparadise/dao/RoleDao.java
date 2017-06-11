package com.jason.bookparadise.dao;

import com.jason.bookparadise.entities.Role;
import com.jason.bookparadise.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/11/23.
 */
@Service
public class RoleDao {

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void saveRole(Role role){
        roleRepository.saveAndFlush(role);
    }

    @Transactional
    public void deleteRole(String username){
        roleRepository.delete(username);
    }

}
