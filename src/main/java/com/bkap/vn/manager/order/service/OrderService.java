package com.bkap.vn.manager.order.service;

import com.bkap.vn.common.entity.Order;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface OrderService {
    public boolean delete(Order order);

    public boolean update(Order order);

    public int add(Order order);

    public Order getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<Order> listOrder();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchOrder(String keySearch);

    public int countByMonth(String datefrom, String dateTo);
}
