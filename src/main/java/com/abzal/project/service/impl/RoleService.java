package com.abzal.project.service.impl;

import com.abzal.project.dao.impl.RoleDao;
import com.abzal.project.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }

    public Role findById(int id){
        return roleDao.findById(id);
    }

}
