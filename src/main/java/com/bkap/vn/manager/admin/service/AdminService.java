package com.bkap.vn.manager.admin.service;

import com.bkap.vn.common.entity.Admin;

import java.util.List;

public interface AdminService {
    public boolean delete();

    public int update();

    public int add();

    public List<Admin> listAdmin();

    public List<Admin> findRange(int firstRow, int lastRow);
}
