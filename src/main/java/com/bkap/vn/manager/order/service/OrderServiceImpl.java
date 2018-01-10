package com.bkap.vn.manager.order.service;

import com.bkap.vn.common.entity.Order;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.order.dao.OrderDAO;
import org.apache.commons.lang3.StringUtils;
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
    public Order getById(int id) {
        return (Order) orderDAO.getById(Order.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return orderDAO.countAll(Order.class, filter);
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int countByMonth(String datefrom, String dateTo) {
        return orderDAO.countByMonth(datefrom,dateTo);
    }

    @Override
    @Transactional
    public int add(Order order) {
        return orderDAO.save(order);
    }

    @Override
    @Transactional
    public List<Order> listOrder() {
        return orderDAO.findAll(Order.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return orderDAO.getRange(Order.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchOrder(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and qty = " + keySearch)
                    .append(" or amount = " + keySearch);
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
