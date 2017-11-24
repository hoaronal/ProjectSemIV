package com.bkap.vn.common.util;

import com.bkap.vn.common.exception.DataAccessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class AbtractDAOImpl implements AbtractDAO {

    final static Logger logger = LogManager.getLogger(AbtractDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    @Override
    @Transactional
    public Integer save(Object obj) {
        Integer result = null;
        try {
            startOperation();
            result = (Integer) session.save(obj);
        } catch (HibernateException e) {
            logger.error("save : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return result;
    }

    @Override
    @Transactional
    public boolean update(Object obj) {
        boolean check = true;
        try {
            startOperation();
            session.update(obj);
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("update : " + e.toString());
            check = false;
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return check;
    }

    @Override
    @Transactional
    public boolean delete(Object obj) {
        boolean check = true;
        try {
            startOperation();
            session.delete(obj);
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("delete : " + e.toString());
            check = false;
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return check;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(Object obj) {
        boolean check = true;
        try {
            startOperation();
            session.saveOrUpdate(obj);
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("saveOrUpdate : " + e.toString());
            check = false;
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return check;
    }

    @Override
    @Transactional
    public Object merge(Object obj) {
        Object result = null;
        try {
            startOperation();
            result = session.merge(obj);
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("merge : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return result;
    }

    @Override
    @Transactional
    public Object loadById(Class clazz, Serializable id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, id);
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("loadById : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }

    @Override
    @Transactional
    public Object getById(Class clazz, Serializable id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.get(clazz, id);
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("getById : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }

    @Override
    @Transactional
    public List findByProperty(Class clazz, String propertyName, Object value) {
        List objects = null;
        try {
            startOperation();
            Query query = session
                    .createQuery("from " + clazz.getName() + " as model where model." + propertyName + "= ?");
            query.setParameter(0, value);
            objects = query.list();
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("findByProperty : " + e.toString());
            //handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }

    @Override
    @Transactional
    public List findLikeProperty(Class clazz, String propertyName, Object value) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery(
                    "from " + clazz.getName() + " as model where model." + propertyName + " like :keySearch");
            query.setParameter("keySearch", "%" + value + "%");
            objects = query.list();
            //tx.commit();
        } catch (HibernateException e) {
            logger.error("findByProperty : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }

    @Override
    @Transactional
    public List findAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            //tx.commit();
            session.close();
        } catch (HibernateException e) {
            logger.error("findAll : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }

    protected void handleException(HibernateException e) throws DataAccessException {
        HibernateFactory.rollback(tx);
        throw new DataAccessException(e);
    }

    protected void startOperation() throws HibernateException {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
    }
}
