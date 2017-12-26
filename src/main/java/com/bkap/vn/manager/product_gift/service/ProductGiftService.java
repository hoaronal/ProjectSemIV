package com.bkap.vn.manager.product_gift.service;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.entity.ProductGift;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface ProductGiftService {
    public boolean delete(ProductGift productGift);

    public boolean update(ProductGift productGift);

    public int add(ProductGift productGift);

    public ProductGift getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);



    public List<ProductGift> listProductGift();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchProductGift(String keySearch);
}
