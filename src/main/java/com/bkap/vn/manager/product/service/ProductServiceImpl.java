package com.bkap.vn.manager.product.service;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.manager.product.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public boolean delete(Product user) {
        return productDAO.delete(user);
    }

    @Override
    @Transactional
    public boolean update(Product user) {
        return productDAO.update(user);
    }

    @Override
    @Transactional
    public Product getById(int id) {
        return (Product) productDAO.getById(Product.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return productDAO.findAll(Product.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return productDAO.getAllByKeySearch(Product.class,  filter).size();
    }

    @Override
    @Transactional
    public int add(Product user) {
        return productDAO.save(user);
    }

    @Override
    @Transactional
    public List<Product> listAdmin() {
        return productDAO.findAll(Product.class);
    }

    @Override
    @Transactional
    public List<Product> findRange(int firstRow, int lastRow, String filter) {
        return productDAO.getRange(Product.class, firstRow, lastRow, filter);
    }
}
