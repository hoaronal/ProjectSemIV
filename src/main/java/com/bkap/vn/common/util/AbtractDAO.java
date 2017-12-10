package com.bkap.vn.common.util;

import com.bkap.vn.common.pagination.PaggingResult;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public interface AbtractDAO {

    public Integer save(Object obj);

    public boolean update(Object obj);

    public boolean delete(Object obj);

    public boolean saveOrUpdate(Object obj);

    public Object merge(Object obj);

    public Object loadById(Class clazz, Serializable id);

    public Object getById(Class clazz, Serializable id);

    public List findByProperty(Class clazz, String propertyName, Object value);

    public List findLikeProperty(Class clazz, String propertyName, Object value);
    public PaggingResult findRange(Class clazz, int firstRow, int lastRow);

    public PaggingResult getRange(Class clazz, int currentPage, int rowPerpage, String filter);

    public PaggingResult getAllByKeySearch(Class clazz, String filter);
    public List findAll(Class clazz);

    public int countAll(Class clazz, String filter);

}
