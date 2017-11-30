package com.bkap.vn.manager.user.service;

import com.bkap.vn.common.entity.Users;

import java.util.List;

public interface UserService {
    public boolean delete(Users user);

    public boolean update(Users user);

    public int add(Users user);

    public Users getById(int id);

    public int countAll();

    public List<Users> listAdmin();

    public List<Users> findRange(int firstRow, int lastRow);
}
