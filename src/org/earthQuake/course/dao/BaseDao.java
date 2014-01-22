package org.earthQuake.course.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao {
    private SessionFactory sessionFactory;

    public Logger log = LoggerFactory.getLogger(BaseDao.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public Session getSession() {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();
            log.info("通过 getCurrentSession() 得到。");
        }
        catch(HibernateException ex)
        {           
            session = sessionFactory.openSession();     
            log.info("通过 openSession() 得到。");
        }
        
        return session;
    }
    
    public void close(Session session) {
        if(session != null) {
            session.close();
        }
    }
}
