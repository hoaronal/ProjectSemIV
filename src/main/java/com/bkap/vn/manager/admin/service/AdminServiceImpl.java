package com.bkap.vn.manager.admin.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.manager.admin.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
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
    public List<Admin> listAdmin() {
        return adminDAO.findAll(Admin.class);
    }
}
