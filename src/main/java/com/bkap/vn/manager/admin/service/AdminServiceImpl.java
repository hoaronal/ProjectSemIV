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
    public boolean delete(Object o) {
        return adminDAO.delete(o);
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
    public Admin getById(int id){
        return (Admin) adminDAO.getById(Admin.class, id);
    }

    @Override
    @Transactional
    public List<Admin> listAdmin() {
        return adminDAO.findAll(Admin.class);
    }

    @Override
    @Transactional
    public List<Admin> findRange(int firstRow, int lastRow) {
        return adminDAO.findRange(Admin.class, firstRow, lastRow);
    }
}
