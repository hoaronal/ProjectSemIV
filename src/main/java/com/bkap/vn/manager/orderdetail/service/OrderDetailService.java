package com.bkap.vn.manager.orderdetail.service;

import com.bkap.vn.common.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public boolean delete(OrderDetail orderDetail);

    public boolean update(OrderDetail orderDetail);

    public int add(OrderDetail orderDetail);

    public OrderDetail getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<OrderDetail> listAdmin();

    public List<OrderDetail> findRange(int firstRow, int lastRow, String filter);
}
