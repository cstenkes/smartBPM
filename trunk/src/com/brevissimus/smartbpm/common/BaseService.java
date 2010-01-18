package com.brevissimus.smartbpm.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 
 *<p>BaseService</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.22.</p>
 */
public class BaseService //extends HibernateDaoSupport 
{
    
    @Autowired
    protected SessionFactory sessionFactory; 

    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }
    
  
    @Autowired
    public BaseService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected BaseService() {
    }

    
	public Session getCurrentSession(){
	    //createHibernateTemplate(sessionFactory).
        //return getHibernateTemplate().getSessionFactory().getCurrentSession();

	    return createHibernateTemplate(sessionFactory).getSessionFactory().getCurrentSession();
	    //return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
}
