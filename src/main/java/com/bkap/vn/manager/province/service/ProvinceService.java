package com.bkap.vn.manager.province.service;

import com.bkap.vn.common.entity.Province;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface ProvinceService {
    public boolean delete(Province province);

    public boolean update(Province province);

    public int add(Province province);

    public Province getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<Province> listProvince();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchProvince(String keySearch);
}
