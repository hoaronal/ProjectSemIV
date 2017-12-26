package com.bkap.vn.manager.product.service;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.product.dao.ProductDAO;
import org.apache.commons.lang3.StringUtils;
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
    public boolean delete(Product product) {
        return productDAO.delete(product);
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    @Transactional
    public Product getById(int id) {
        return (Product) productDAO.getById(Product.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return productDAO.findAll(Product.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    public int countAllByCategory(int idCategory) {
        return productDAO.countAllByCategory(idCategory);
    }

    @Override
    @Transactional
    public int add(Product product) {
        return productDAO.save(product);
    }

    @Override
    @Transactional
    public List<Product> listProduct() {
        return productDAO.findAll(Product.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return productDAO.getRange(Product.class, firstRow, lastRow, filter);
    }

    @Override
    public List<Product> getNewProduct() {
        return productDAO.getNewProduct();
    }

    @Override
    public List<Product> getSaleProduct(String filter) {
        return productDAO.getProductByFilter(filter);
    }

    @Override
    public String generateQuerySearchProduct(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and productName like N'%" + keySearch + "%'")
                    .append(" or detail like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }

    @Override
    public List<Product> getByCategory(int idCategory) {
        return productDAO.getByCategory(idCategory);
    }
}
