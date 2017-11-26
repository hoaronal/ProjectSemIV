package com.bkap.vn.manager.user.service;

import com.bkap.vn.common.entity.User;
import com.bkap.vn.manager.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public boolean delete() {
        return false;
    }

    @Override
    @Transactional
    public int update() {
        return 0;
    }

    @Override
    @Transactional
    public int add() {
        return 0;
    }

    @Override
    @Transactional
    public List<User> listAdmin() {
        return userDAO.findAll(User.class);
    }

    @Override
    @Transactional
    public List<User> findRange(int firstRow, int lastRow) {
        return userDAO.findRange(User.class, firstRow, lastRow);
    }
}
