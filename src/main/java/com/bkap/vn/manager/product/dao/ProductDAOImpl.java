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
        startOperation();
        List<Product> productList = session.createNativeQuery(
                "SELECT * FROM product WHERE create_date BETWEEN '2017-12-01 00:00:00' and '2017-12-14 00:00:00'",Product.class ).getResultList();
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        return productList;
    }

    @Override
    public List<Product> getByCategory(int idCategory) {
        startOperation();
        List<Product> productList = session.createNativeQuery(
                "SELECT * FROM product WHERE category_id = " + idCategory,Product.class ).getResultList();
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        return productList;
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
        startOperation();
        List<Product> productList = session.createNativeQuery(
                "SELECT * FROM product " + filter, Product.class ).getResultList();
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        return productList;
    }
}
