package com.bkap.vn.manager.product.service;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface ProductService {
    public boolean delete(Product product);

    public boolean update(Product product);

    public int add(Product product);

    public Product getById(int id);

    public int countAll(String filter);

    public List<Product> getNewProduct();

    public List<Product> getProductByFilter(String filter);

    public List<Product> getByCategory(int idCategory);

    public int countAllByKeySearch(String filter);

    public int countAllByCategory(int idCategory);

    public List<Product> listProduct();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchProduct(String keySearch);
}
