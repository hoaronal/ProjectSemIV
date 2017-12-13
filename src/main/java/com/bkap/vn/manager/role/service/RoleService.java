package com.bkap.vn.manager.role.service;

import com.bkap.vn.common.entity.Role;

import java.util.List;

public interface RoleService {
    public boolean delete(Role role);

    public boolean update(Role role);

    public int add(Role role);

    public Role getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<Role> listAdmin();

    public List<Role> findRange(int firstRow, int lastRow, String filter);
}
