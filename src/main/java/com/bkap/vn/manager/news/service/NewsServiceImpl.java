package com.bkap.vn.manager.news.service;

import com.bkap.vn.common.entity.News;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.manager.news.dao.NewsDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    @Transactional
    public boolean delete(News news) {
        return newsDAO.delete(news);
    }

    @Override
    @Transactional
    public boolean update(News news) {
        return newsDAO.update(news);
    }

    @Override
    @Transactional
    public News getById(int id) {
        return (News) newsDAO.getById(News.class, id);
    }

    @Override
    @Transactional
    public int countAll(String filter) {
        return newsDAO.findAll(News.class).size();
    }

    @Override
    @Transactional
    public int countAllByKeySearch(String filter) {
        return 0;
    }

    @Override
    @Transactional
    public int add(News News) {
        return newsDAO.save(News);
    }

    @Override
    @Transactional
    public List<News> listNews() {
        return newsDAO.findAll(News.class);
    }

    @Override
    @Transactional
    public PaggingResult findRange(int firstRow, int lastRow, String filter) {
        return newsDAO.getRange(News.class, firstRow, lastRow, filter);
    }

    @Override
    public String generateQuerySearchNews(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and title like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return sql.toString();
        }
    }
}
