package com.bkap.vn.manager.admin.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface AdminService {
    public boolean delete(Admin user);

    public boolean update(Admin user);

    public int add(Admin user);

    public Admin getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<Admin> listAdmin();

    public PaggingResult findRange(int currentPage, int rowPerpage, String filter);

    public String generateQuerySearchAdmin(String keySearch);
}
