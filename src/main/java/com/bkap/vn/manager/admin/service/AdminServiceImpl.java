package com.bkap.vn.manager.admin.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.admin.dao.AdminDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public boolean delete(Admin admin) {
        return adminDAO.delete(admin);
    }

    @Override
    @Transactional
    public boolean update(Admin admin) {
        return adminDAO.update(admin);
    }

    @Override
    public Admin getByAcount(String account) {
        List<Admin> admins = adminDAO.findByProperty(Admin.class, "account", account);
        if (admins != null && admins.size() > 0) {
            return admins.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Admin getById(int id) {
        return (Admin) adminDAO.getById(Admin.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return adminDAO.countAll(Admin.class, filter);
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(Admin admin) {
        return adminDAO.save(admin);
    }

    @Override
    @Transactional
    public List<Admin> listAdmin() {
        return adminDAO.findAll(Admin.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int currentPage, int rowPerpage, String filter) {
        return adminDAO.getRange(Admin.class, currentPage, rowPerpage, filter);
    }

    @Override
    public String generateQuerySearchAdmin(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and account like N'%" + keySearch + "%'")
                    .append(" or email like N'%" + keySearch + "%'")
                    .append(" or phone like N'%" + keySearch + "%'")
                    .append(" or address like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
