package com.bkap.vn.manager.gift.service;

import com.bkap.vn.common.entity.Gift;

import java.util.List;

public interface GiftService {
    public boolean delete(Gift gift);

    public boolean update(Gift gift);

    public int add(Gift gift);

    public Gift getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<Gift> listAdmin();

    public List<Gift> findRange(int firstRow, int lastRow, String filter);
}
