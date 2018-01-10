package com.bkap.vn.manager.order.dao;

import com.bkap.vn.common.util.AbtractDAO;

public interface OrderDAO extends AbtractDAO {

    public int countByMonth(String datefrom, String dateTo);
}
