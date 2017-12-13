package com.bkap.vn.manager.gift.service;

import com.bkap.vn.common.entity.Gift;
import com.bkap.vn.manager.gift.dao.GiftDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GiftServiceImpl implements GiftService {
    @Autowired
    private GiftDAO giftDAO;

    @Override
    @Transactional
    public boolean delete(Gift gift) {
        return giftDAO.delete(gift);
    }

    @Override
    @Transactional
    public boolean update(Gift gift) {
        return giftDAO.update(gift);
    }

    @Override
    @Transactional
    public int add(Gift gift) {
        return giftDAO.save(gift);
    }

    @Override
    @Transactional
    public Gift getById(int id) {
        return (Gift) giftDAO.getById(Gift.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return giftDAO.findAll(Gift.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return giftDAO.getAllByKeySearch(Gift.class, filter).size();
    }

    @Override
    @Transactional
    public List<Gift> listAdmin() {
        return giftDAO.findAll(Gift.class);
    }

    @Override
    @Transactional
    public List<Gift> findRange(int firstRow, int lastRow, String filter) {
        return giftDAO.getRange(Gift.class, firstRow, lastRow, filter);
    }
}
