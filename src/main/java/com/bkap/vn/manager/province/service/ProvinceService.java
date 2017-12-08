package com.bkap.vn.manager.province.service;

import com.bkap.vn.common.entity.Province;

import java.util.List;

public interface ProvinceService {

    public boolean delete(Province province);

    public boolean update(Province province);

    public int add(Province province);

    public Province getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<Province> listProvince();

    public List<Province> findRange(int firstRow, int lastRow, String filter);
}
