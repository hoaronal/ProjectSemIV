package com.bkap.vn.manager.admin.dao;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.util.AbtractDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AdminDAOImpl extends AbtractDAOImpl implements AdminDAO{



    /*@Override
    public void addAdmin(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.update(admin);
    }

    @Override
    public Admin getAdminById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Admin admin = (Admin) session.get(Admin.class, new Integer(id));
        return admin;
    }

    @Override
    public void removeAdmin(int id) {
        Session session = sessionFactory.getCurrentSession();
        Admin admin = (Admin) session.get(Admin.class, new Integer(id));
        if(null != admin){
            session.delete(admin);
        }
    }

    @Override
    public List<Admin> listAdmins() {
        Session session = sessionFactory.getCurrentSession();
        List<Admin> adminList = session.createQuery("from Admin").list();
        return adminList;
    }*/
}
