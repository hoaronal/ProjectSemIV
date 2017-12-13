package com.bkap.vn.manager.orderdetail.service;

import com.bkap.vn.common.entity.OrderDetail;
import com.bkap.vn.manager.orderdetail.dao.OrderDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDAO orderDetailDAO;
    @Override
    @Transactional
    public boolean delete(OrderDetail orderDetail) {
        return orderDetailDAO.delete(orderDetail);
    }

    @Override
    @Transactional
    public boolean update(OrderDetail orderDetail) {
        return orderDetailDAO.update(orderDetail);
    }

    @Override
    @Transactional
    public int add(OrderDetail orderDetail) {
        return orderDetailDAO.save(orderDetail);
    }

    @Override
    @Transactional
    public OrderDetail getById(int id) {
        return (OrderDetail) orderDetailDAO.getById(OrderDetail.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return orderDetailDAO.findAll(OrderDetail.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return orderDetailDAO.getAllByKeySearch(OrderDetail.class, filter).size();
    }

    @Override
    @Transactional
    public List<OrderDetail> listAdmin() {
        return orderDetailDAO.findAll(OrderDetail.class);
    }

    @Override
    @Transactional
    public List<OrderDetail> findRange(int firstRow, int lastRow, String filter) {
        return orderDetailDAO.getRange(OrderDetail.class, firstRow,lastRow,filter);
    }
}
