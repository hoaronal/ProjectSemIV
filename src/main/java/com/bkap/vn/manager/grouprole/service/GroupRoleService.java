package com.bkap.vn.manager.grouprole.service;

import com.bkap.vn.common.entity.GroupRole;

import java.util.List;

public interface GroupRoleService {
    public boolean delete(GroupRole groupRole);

    public boolean update(GroupRole groupRole);

    public int add(GroupRole groupRole);

    public GroupRole getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<GroupRole> listAdmin();

    public List<GroupRole> findRange(int firstRow, int lastRow, String filter);
}
