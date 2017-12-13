package com.bkap.vn.manager.role.service;

import com.bkap.vn.common.entity.Role;
import com.bkap.vn.manager.role.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;


    @Override
    @Transactional
    public boolean delete(Role role) {
        return roleDAO.delete(role);
    }

    @Override
    @Transactional
    public boolean update(Role role) {
        return roleDAO.update(role);
    }

    @Override
    @Transactional
    public int add(Role role) {
        return roleDAO.save(role);
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return (Role) roleDAO.getById(Role.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return roleDAO.findAll(Role.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return roleDAO.getAllByKeySearch(Role.class, filter).size();
    }

    @Override
    @Transactional
    public List<Role> listAdmin() {
        return roleDAO.findAll(Role.class);
    }

    @Override
    @Transactional
    public List<Role> findRange(int firstRow, int lastRow, String filter) {
        return roleDAO.getRange(Role.class, firstRow,lastRow,filter);
    }
}
