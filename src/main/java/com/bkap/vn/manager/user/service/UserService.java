package com.bkap.vn.manager.user.service;

import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface UserService {
    public boolean delete(Users user);

    public boolean update(Users user);

    public int add(Users user);

    public Users getById(int id);

    public Users getByProperty(String property, String value);

    public Users getByUsername(String username);

    public Users getByEmail(String username);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<Users> listUser();

    public PaggingResult findRange(int currentPage, int rowPerpage, String filter);

    public String generateQuerySearchUser(String keySearch);
}
