package com.bkap.vn.manager.news.service;

import com.bkap.vn.common.entity.News;
import com.bkap.vn.common.pagination.PaggingResult;

import java.util.List;

public interface NewsService {
    public boolean delete(News News);

    public boolean update(News News);

    public int add(News News);

    public News getById(int id);

    public int countAll(String filter);

    public int countAllByKeySearch(String filter);

    public List<News> listNews();

    public PaggingResult findRange(int firstRow, int lastRow, String filter);

    public String generateQuerySearchNews(String keySearch);
}
