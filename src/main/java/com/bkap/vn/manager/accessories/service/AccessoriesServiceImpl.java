package com.bkap.vn.manager.accessories.service;

import com.bkap.vn.common.entity.Accessories;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.accessories.dao.AccessoriesDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccessoriesServiceImpl implements AccessoriesService {

    @Autowired
    private AccessoriesDAO accessoriesDAO;

    @Override
    @Transactional
    public boolean delete(Accessories accessories) {
        return accessoriesDAO.delete(accessories);
    }

    @Override
    @Transactional
    public boolean update(Accessories accessories) {
        return accessoriesDAO.update(accessories);
    }

    @Override
    @Transactional
    public Accessories getById(int id) {
        return (Accessories) accessoriesDAO.getById(Accessories.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return accessoriesDAO.findAll(Accessories.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(Accessories accessories) {
        return accessoriesDAO.save(accessories);
    }

    @Override
    @Transactional
    public List<Accessories> listAccessories() {
        return accessoriesDAO.findAll(Accessories.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return accessoriesDAO.getRange(Accessories.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchAccessories(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and name like N'%" + keySearch + "%'")
                    .append(" or detail like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
