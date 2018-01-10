package com.bkap.vn.manager.order.dao;

import com.bkap.vn.common.util.AbtractDAOImpl;
import com.bkap.vn.common.util.HibernateFactory;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl extends AbtractDAOImpl implements OrderDAO {

    @Override
    public int countByMonth(String datefrom, String dateTo) {
        try {
            startOperation();
            StringBuilder query = new StringBuilder("SELECT COUNT(1) from Order");
            query.append(" obj where create_date BETWEEN '" + datefrom + "' AND '" + dateTo + "'");
            Query countQuery = session.createQuery(query.toString());
            Long countResults = (Long) countQuery.uniqueResult();
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
}
