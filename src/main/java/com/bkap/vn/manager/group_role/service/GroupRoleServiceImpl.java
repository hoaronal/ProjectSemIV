package com.bkap.vn.manager.group_role.service;

import com.bkap.vn.common.entity.GroupRole;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.group_role.dao.GroupRoleDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {

    @Autowired
    private GroupRoleDAO groupRoleDAO;

    @Override
    @Transactional
    public boolean delete(GroupRole groupRole) {
        return groupRoleDAO.delete(groupRole);
    }

    @Override
    @Transactional
    public boolean update(GroupRole groupRole) {
        return groupRoleDAO.update(groupRole);
    }

    @Override
    @Transactional
    public GroupRole getById(int id) {
        return (GroupRole) groupRoleDAO.getById(GroupRole.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return groupRoleDAO.findAll(GroupRole.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(GroupRole groupRole) {
        return groupRoleDAO.save(groupRole);
    }

    @Override
    @Transactional
    public List<GroupRole> listGroupRole() {
        return groupRoleDAO.findAll(GroupRole.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return groupRoleDAO.getRange(GroupRole.class, firstRow, lastRow, filter);
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
