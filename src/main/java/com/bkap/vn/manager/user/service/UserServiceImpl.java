package com.bkap.vn.manager.user.service;

import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.user.dao.UserDAO;
import org.apache.commons.lang3.StringUtils;
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
    public int countAll(String filter) {
        return userDAO.countAll(Users.class,filter);
    }


    @Override
    public Users getByEmail(String email) {
        List<Users> users = userDAO.findByProperty(Users.class,"email",email);
        if(users != null && users.size() > 0)
            return users.get(0);
        else
            return null;
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(Users user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public List<Users> listUser() {
        return userDAO.findAll(Users.class);
    }

    @Override
    public Users getByUsername(String username) {
        List<Users> users = userDAO.findByProperty(Users.class,"username",username);
        if(users != null && users.size() > 0)
            return users.get(0);
        else
            return null;
    }

    @Override
    @Transactional
    public PaggingResult findRange(int currentPage, int rowPerpage, String filter) {
        return userDAO.getRange(Users.class, currentPage, rowPerpage, filter);
    }

    @Override
    public String generateQuerySearchUser(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and username like N'%" + keySearch + "%'")
                    .append(" or email like N'%" + keySearch + "%'")
                    .append(" or phone like N'%" + keySearch + "%'")
                    .append(" or address like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
