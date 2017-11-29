package com.bkap.vn.common.util;

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
    public List findRange(Class clazz, int firstRow, int lastRow);

    public List getRange(Class clazz, int firstRow, int lastRow);
    public List findAll(Class clazz);

}
