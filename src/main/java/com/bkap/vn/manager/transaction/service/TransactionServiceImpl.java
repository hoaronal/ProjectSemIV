package com.bkap.vn.manager.transaction.service;

import com.bkap.vn.common.entity.Transaction;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.transaction.dao.TransactionDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Override
    @Transactional
    public boolean delete(Transaction transaction) {
        return transactionDAO.delete(transaction);
    }

    @Override
    @Transactional
    public boolean update(Transaction transaction) {
        return transactionDAO.update(transaction);
    }

    @Override
    @Transactional
    public Transaction getById(int id) {
        return (Transaction) transactionDAO.getById(Transaction.class, id);
    }

    @Override
    @Transactional
    public int countAll() {
        return transactionDAO.findAll(Transaction.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(Transaction transaction) {
        return transactionDAO.save(transaction);
    }

    @Override
    @Transactional
    public List<Transaction> listTransaction() {
        return transactionDAO.findAll(Transaction.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return transactionDAO.getRange(Transaction.class, firstRow, lastRow, filter);
    }

    @Override
    public List<Transaction> getTransactionByUserId(int id) {
        return transactionDAO.findByProperty(Transaction.class,"userId",id);
    }

    @Override
    public String generateQuerySearchTransaction(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and userName = " + keySearch)
                    .append(" or userEmail = " + keySearch)
                    .append(" or userPhone = " + keySearch);
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
