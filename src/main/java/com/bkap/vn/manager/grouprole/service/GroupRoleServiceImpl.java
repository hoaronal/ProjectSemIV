package com.bkap.vn.manager.grouprole.service;

import com.bkap.vn.common.entity.GroupRole;
import com.bkap.vn.manager.grouprole.dao.GroupRoleDAO;
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
    public int add(GroupRole groupRole) {
        return groupRoleDAO.save(groupRole);
    }

    @Override
    @Transactional
    public GroupRole getById(int id) {
        return (GroupRole) groupRoleDAO.getById(GroupRole.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return groupRoleDAO.findAll(GroupRole.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return groupRoleDAO.getAllByKeySearch(GroupRole.class, filter).size();
    }

    @Override
    @Transactional
    public List<GroupRole> listAdmin() {
        return groupRoleDAO.findAll(GroupRole.class);
    }

    @Override
    @Transactional
    public List<GroupRole> findRange(int firstRow, int lastRow, String filter) {
        return groupRoleDAO.getRange(GroupRole.class, firstRow,lastRow,filter);
    }
}
