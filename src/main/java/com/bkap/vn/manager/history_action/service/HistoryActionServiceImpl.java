package com.bkap.vn.manager.history_action.service;

import com.bkap.vn.common.entity.HistoryAction;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.history_action.dao.HistoryActionDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoryActionServiceImpl implements HistoryActionService {

    @Autowired
    private HistoryActionDAO HistoryActionDAO;

    @Override
    @Transactional
    public boolean delete(HistoryAction historyAction) {
        return HistoryActionDAO.delete(historyAction);
    }

    @Override
    @Transactional
    public boolean update(HistoryAction historyAction) {
        return HistoryActionDAO.update(historyAction);
    }

    @Override
    @Transactional
    public HistoryAction getById(int id) {
        return (HistoryAction) HistoryActionDAO.getById(HistoryAction.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return HistoryActionDAO.findAll(HistoryAction.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(HistoryAction historyAction) {
        return HistoryActionDAO.save(historyAction);
    }

    @Override
    @Transactional
    public List<HistoryAction> listHistoryAction() {
        return HistoryActionDAO.findAll(HistoryAction.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return HistoryActionDAO.getRange(HistoryAction.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchHistoryAction(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and clientInfo like N'%" + keySearch + "%'")
                    .append(" or accessType = " + keySearch);
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
