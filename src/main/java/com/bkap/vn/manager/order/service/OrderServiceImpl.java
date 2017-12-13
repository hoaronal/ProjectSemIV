package com.bkap.vn.manager.order.service;

import com.bkap.vn.common.entity.Order;
import com.bkap.vn.manager.order.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public boolean delete(Order order) {
        return orderDAO.delete(order);
    }

    @Override
    @Transactional
    public boolean update(Order order) {
        return orderDAO.update(order);
    }

    @Override
    @Transactional
    public int add(Order order) {
        return orderDAO.save(order);
    }

    @Override
    @Transactional
    public Order getById(int id) {
        return (Order) orderDAO.getById(Order.class,id);
    }

    @Override
    @Transactional
    public int countAll() {
        return orderDAO.findAll(Order.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return orderDAO.getAllByKeySearch(Order.class, filter).size();
    }

    @Override
    @Transactional
    public List<Order> listAdmin() {
        return orderDAO.findAll(Order.class);
    }

    @Override
    @Transactional
    public List<Order> findRange(int firstRow, int lastRow, String filter) {
        return orderDAO.getRange(Order.class, firstRow,lastRow, filter);
    }
}
