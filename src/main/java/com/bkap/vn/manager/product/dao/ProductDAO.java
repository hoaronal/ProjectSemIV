package com.bkap.vn.manager.product.dao;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.util.AbtractDAO;

import java.util.List;

public interface ProductDAO extends AbtractDAO {

    public List<Product> getNewProduct();

    public List<Product> getByCategory(int idCategory);

    public int countAllByCategory(int idCategory);

    public List<Product> getProductByFilter(String filter);
}
