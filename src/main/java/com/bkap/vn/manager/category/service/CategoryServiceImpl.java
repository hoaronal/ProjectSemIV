package com.bkap.vn.manager.category.service;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.Category;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.category.dao.CategoryDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public boolean delete(Category category) {
        return categoryDAO.delete(category);
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    @Transactional
    public Category getById(int id) {
        return (Category) categoryDAO.getById(Category.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return categoryDAO.countAll(Category.class,filter);
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(Category user) {
        return categoryDAO.save(user);
    }

    @Override
    @Transactional
    public List<Category> listCategory() {
        return categoryDAO.findAll(Category.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int currentPage, int rowPerpage, String filter) {
        return categoryDAO.getRange(Category.class, currentPage, rowPerpage, filter);
    }

    @Override
    public String generateQuerySearchCategory(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and account like N'%" + keySearch + "%'")
                    .append(" or email like N'%" + keySearch + "%'")
                    .append(" or phone like N'%" + keySearch + "%'")
                    .append(" or address like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
