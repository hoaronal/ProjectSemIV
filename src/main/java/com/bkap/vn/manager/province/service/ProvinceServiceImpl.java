package com.bkap.vn.manager.province.service;

import com.bkap.vn.common.entity.Province;
import com.bkap.vn.manager.province.dao.ProvinceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvinceServiceImpl implements  ProvinceService{

    @Autowired
    private ProvinceDAO provinceDAO;


    @Override
    @Transactional
    public boolean delete(Province province) {
        return provinceDAO.delete(province);
    }

    @Override
    @Transactional
    public boolean update(Province province) {
        return provinceDAO.update(province);
    }

    @Override
    @Transactional
    public Province getById(int id) {
        return (Province) provinceDAO.getById(Province.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return provinceDAO.findAll(Province.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return provinceDAO.getAllByKeySearch(Province.class,  filter).size();
    }

    @Override
    @Transactional
    public int add(Province user) {
        return provinceDAO.save(user);
    }

    @Override
    @Transactional
    public List<Province> listProvince() {
        return provinceDAO.findAll(Province.class);
    }

    @Override
    @Transactional
    public List<Province> findRange(int firstRow, int lastRow, String filter) {
        return provinceDAO.getRange(Province.class, firstRow, lastRow, filter);
    }
}
