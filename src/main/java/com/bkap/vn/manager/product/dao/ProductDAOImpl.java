package com.bkap.vn.manager.product.dao;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.util.AbtractDAOImpl;
import com.bkap.vn.common.util.HibernateFactory;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl extends AbtractDAOImpl implements ProductDAO {


    @Override
    public List<Product> getNewProduct() {
        try {
            startOperation();
            List<Product> productList = session.createNativeQuery(
                    "SELECT * FROM product ORDER BY id OFFSET 0 ROWS FETCH NEXT 20 ROWS ONLY ", Product.class).getResultList();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            return productList;
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return null;
    }

    @Override
    public List<Product> getByCategory(int idCategory) {
        try {
            startOperation();
            List<Product> productList = session.createNativeQuery(
                    "SELECT * FROM product WHERE category_id = " + idCategory, Product.class).getResultList();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            return productList;
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return null;
    }

    @Override
    public int countAllByCategory(int idCategory) {
        Integer countResults = null;
        try {
            startOperation();
            StringBuilder query = new StringBuilder("SELECT COUNT(1) from ");
            query.append("product").append(" WHERE category_id = " + idCategory);
            Query countQuery = session.createNativeQuery(query.toString());
            countResults = (Integer) countQuery.uniqueResult();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            return countResults.intValue();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return 0;
    }

    @Override
    public List<Product> getProductByFilter(String filter) {
        try {
            startOperation();
            List<Product> productList = session.createNativeQuery(
                    "SELECT * FROM product " + filter, Product.class).getResultList();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            return productList;
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return null;
    }
}
