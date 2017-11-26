package com.bkap.vn.manager.user.service;

import com.bkap.vn.common.entity.User;

import java.util.List;

public interface UserService {
    public boolean delete();

    public int update();

    public int add();

    public List<User> listAdmin();

    public List<User> findRange(int firstRow, int lastRow);
}
