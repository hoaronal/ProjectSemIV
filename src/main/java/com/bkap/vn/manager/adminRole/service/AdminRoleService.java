package com.bkap.vn.manager.adminRole.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.AdminRole;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface AdminRoleService {
    public boolean delete(AdminRole adminRole);

    public boolean update(AdminRole adminRole);

    public int add(AdminRole adminRole);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<AdminRole> getAll();

    public List getByAdminId(Admin admin);

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchAdminRole(String keySearch);
}
