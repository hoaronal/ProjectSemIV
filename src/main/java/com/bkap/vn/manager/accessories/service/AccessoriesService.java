package com.bkap.vn.manager.accessories.service;

import com.bkap.vn.common.entity.Accessories;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface AccessoriesService {
    public boolean delete(Accessories accessories);

    public boolean update(Accessories accessories);

    public int add(Accessories accessories);

    public Accessories getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<Accessories> listAccessories();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchAccessories(String keySearch);
}
