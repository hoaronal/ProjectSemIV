package com.bkap.vn.manager.admin.service;

import com.bkap.vn.common.entity.Admin;

import java.util.List;

public interface AdminService {
    public boolean delete(Object o);

    public int update();

    public int add();

    public Admin getById(int id);

    public List<Admin> listAdmin();

    public List<Admin> findRange(int firstRow, int lastRow);
}
