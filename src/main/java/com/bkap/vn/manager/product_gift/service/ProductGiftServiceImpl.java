package com.bkap.vn.manager.product_gift.service;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.entity.ProductGift;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.product_gift.dao.ProductGiftDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductGiftServiceImpl implements ProductGiftService {

    @Autowired
    private ProductGiftDAO productDAO;

    @Override
    @Transactional
    public boolean delete(ProductGift productGift) {
        return productDAO.delete(productGift);
    }

    @Override
    @Transactional
    public boolean update(ProductGift productGift) {
        return productDAO.update(productGift);
    }

    @Override
    @Transactional
    public ProductGift getById(int id) {
        return (ProductGift) productDAO.getById(ProductGift.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return productDAO.findAll(ProductGift.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(ProductGift productGift) {
        return productDAO.save(productGift);
    }

    @Override
    @Transactional
    public List<ProductGift> listProductGift() {
        return productDAO.findAll(ProductGift.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return productDAO.getRange(Product.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchProductGift(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and productName like N'%" + keySearch + "%'")
                    .append(" or detail like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
