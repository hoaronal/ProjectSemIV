package com.bkap.vn.manager.transaction.service;

import com.bkap.vn.common.entity.Transaction;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface TransactionService {
    public boolean delete(Transaction transaction);

    public boolean update(Transaction transaction);

    public int add(Transaction transaction);

    public Transaction getById(int id);

    public int countAll();

    public int countAllByKeySearch(String filter);

    public List<Transaction> getTransactionByUserId(int id);

    public List<Transaction> listTransaction();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchTransaction(String keySearch);
}
