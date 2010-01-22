package com.brevissimus.smartbpm.dao;


import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brevissimus.smartbpm.model.ProcessType;
import com.brevissimus.smartbpm.model.dao.BaseProcessTypeDAO;

/**
 *<p>ProcessTypeDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */

@Repository
public class ProcessTypeDAO extends BaseProcessTypeDAO {
    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(ProcessTypeDAO.class);
       
    @Override 
    public ProcessType getById(Long id, Session session) throws HibernateException {
        ProcessType pt = super.getById(id, session);
        return pt;
    }
    
    /**
     * gets all AttributeTypes
     * @param session 
     * @return processTypes
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public Collection<ProcessType> getAllProcessTypes(Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select pt from ProcessType pt";
        Query query = session.createQuery(hql);
        Collection<ProcessType> list = (Collection<ProcessType>)query.list();
        for (ProcessType processType : list) {
            processType.getNodes();
        }       
        logger.info("ends");
        return list;
    }
}

