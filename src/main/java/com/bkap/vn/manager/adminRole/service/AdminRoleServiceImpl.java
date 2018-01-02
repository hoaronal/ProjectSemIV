package com.bkap.vn.manager.adminRole.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.AdminRole;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.adminRole.dao.AdminRoleDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDAO adminRoleDAO;

    @Override
    @Transactional
    public boolean delete(AdminRole adminRole) {
        return adminRoleDAO.delete(adminRole);
    }

    @Override
    @Transactional
    public boolean update(AdminRole adminRole) {
        return adminRoleDAO.update(adminRole);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return adminRoleDAO.findAll(AdminRole.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    public List<AdminRole> getByAdminId(Admin admin) {
        return adminRoleDAO.findByProperty(AdminRole.class,"admin",admin);
    }

    @Override
    @Transactional
    public int add(AdminRole adminRole) {
        return adminRoleDAO.save(adminRole);
    }

    @Override
    @Transactional
    public List<AdminRole> getAll() {
        return adminRoleDAO.findAll(AdminRole.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return adminRoleDAO.getRange(Role.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchAdminRole(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and roleName like N'%" + keySearch + "%'")
                    .append(" or description like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
