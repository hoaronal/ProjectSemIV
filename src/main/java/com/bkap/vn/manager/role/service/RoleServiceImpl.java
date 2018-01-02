package com.bkap.vn.manager.role.service;

import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.role.dao.RoleDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public boolean delete(Role role) {
        return roleDAO.delete(role);
    }

    @Override
    @Transactional
    public boolean update(Role role) {
        return roleDAO.update(role);
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return (Role) roleDAO.getById(Role.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return roleDAO.findAll(Role.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(Role Role) {
        return roleDAO.save(Role);
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        return roleDAO.findAll(Role.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return roleDAO.getRange(Role.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchRole(String keySearch) {
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
