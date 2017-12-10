package com.bkap.vn.manager.category.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.Category;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface CategoryService {
    public boolean delete(Category user);

    public boolean update(Category user);

    public int add(Category user);

    public Category getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<Category> listCategory();

    public PaggingResult findRange(int currentPage, int rowPerpage, String filter);

    public String generateQuerySearchCategory(String keySearch);
}
