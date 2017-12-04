package com.bkap.vn.manager.user.service;

import com.bkap.vn.common.entity.Users;
import com.bkap.vn.manager.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional
    public boolean delete(Users user) {
        return userDAO.delete(user);
    }

    @Override
    @Transactional
    public boolean update(Users user) {
        return userDAO.update(user);
    }

    @Override
    @Transactional
    public Users getById(int id) {
        return (Users) userDAO.getById(Users.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return userDAO.findAll(Users.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return userDAO.getAllByKeySearch(Users.class,  filter).size();
    }

    @Override
    @Transactional
    public int add(Users user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public List<Users> listAdmin() {
        return userDAO.findAll(Users.class);
    }

    @Override
    @Transactional
    public List<Users> findRange(int firstRow, int lastRow, String filter) {
        return userDAO.getRange(Users.class, firstRow, lastRow, filter);
    }
}
