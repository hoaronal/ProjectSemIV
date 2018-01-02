package com.bkap.vn.common.util;

import com.bkap.vn.common.exception.DataAccessException;
import com.bkap.vn.common.pagination.PaggingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
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
    protected SessionFactory sessionFactory;

    protected Session session;

    protected Transaction tx;

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
    }

    @Override
    public int countAll(Class clazz, String filter) {
        try {
            startOperation();
            StringBuilder query = new StringBuilder("SELECT COUNT(1) from ");
            query.append(clazz.getSimpleName()).append( " obj ")/*.append(filter)*/;
            Query countQuery = session.createQuery(query.toString());
            Long countResults = (Long) countQuery.uniqueResult();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            return countResults.intValue();
        } catch (HibernateException e) {
            logger.error("save : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return 0;
    }

    @Override
    @Transactional
    public Integer save(Object obj) {
        Integer result = null;
        try {
            startOperation();
            result = (Integer) session.save(obj);
            /*session.flush();
            session.clear();
            */
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            session.flush();
            session.clear();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            session.flush();
            session.clear();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
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
    public PaggingResult findRange(Class clazz, int firstResult, int pageSize) {
        PaggingResult paggingResult = new PaggingResult();

        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);
            List objects = query.list();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
        } catch (HibernateException e) {
            logger.error("findRange : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return paggingResult;
    }

    @Override
    @Transactional
    public PaggingResult getRange(Class clazz, int currentPage, int rowPerpage, String filter) {
        PaggingResult paggingResult = new PaggingResult();
        String tableName = getNameTable(clazz);
        int firstRow = (currentPage - 1) * rowPerpage;
        String sql = "SELECT * FROM " + tableName + filter + " OFFSET " + firstRow + " ROWS FETCH NEXT " + rowPerpage + " ROWS ONLY ";
        try {
            startOperation();
            Query query = session.createNativeQuery(sql)
                    .addEntity(clazz);
            List objects = query.list();
            paggingResult.setItem(objects);
            paggingResult.setNumRecordInPage(objects.size());
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
        } catch (HibernateException e) {
            logger.error("getRange : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return paggingResult;
    }

    @Override
    @Transactional
    public PaggingResult getAllByKeySearch(Class clazz, String filter) {
        PaggingResult paggingResult = new PaggingResult();
        List objects = null;
        String tableName = getNameTable(clazz);
        try {
            startOperation();
            Query query = session.createNativeQuery("SELECT * FROM " + tableName + filter).addEntity(clazz);
            objects = query.list();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
        } catch (HibernateException e) {
            logger.error("getAllByKeySearch : " + e.toString());
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return paggingResult;
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
        tx = session.beginTransaction();
    }

    public String getNameTable(Class aClass) {
        String tableName = "";
        ClassMetadata hibernateMetadata = sessionFactory.getClassMetadata(aClass);
        if (hibernateMetadata == null) {
        }
        if (hibernateMetadata instanceof AbstractEntityPersister) {
            AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
            tableName = persister.getTableName();
            String[] columnNames = persister.getKeyColumnNames();
        }
        return tableName;
    }
}
