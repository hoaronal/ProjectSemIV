package com.bkap.vn.manager.order.service;

import com.bkap.vn.common.entity.Order;

import java.util.List;

public interface OrderService {
    public boolean delete(Order order);

    public boolean update(Order order);

    public int add(Order order);

    public Order getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<Order> listAdmin();

    public List<Order> findRange(int firstRow, int lastRow, String filter);
}
