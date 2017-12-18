package com.bkap.vn.manager.group_role.service;

import com.bkap.vn.common.entity.GroupRole;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface GroupRoleService {
    public boolean delete(GroupRole groupRole);

    public boolean update(GroupRole groupRole);

    public int add(GroupRole groupRole);

    public GroupRole getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<GroupRole> listGroupRole();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchRole(String keySearch);
}
