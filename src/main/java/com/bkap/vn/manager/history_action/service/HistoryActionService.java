package com.bkap.vn.manager.history_action.service;

import com.bkap.vn.common.entity.HistoryAction;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface HistoryActionService {
    public boolean delete(HistoryAction historyAction);

    public boolean update(HistoryAction historyAction);

    public int add(HistoryAction historyAction);

    public HistoryAction getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<HistoryAction> listHistoryAction();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchHistoryAction(String keySearch);
}
