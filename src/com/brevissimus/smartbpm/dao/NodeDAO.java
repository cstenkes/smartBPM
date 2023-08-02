package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.brevissimus.smartbpm.common.QueryLogger;
import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.dao.BaseNodeDAO;

/**
 *<p>NodeDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */


public class NodeDAO extends BaseNodeDAO {
    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(NodeDAO.class);

    
    /**
     * gets all Attributes of a given process
     * @param userId 
     * @param processId 
     * @param nodeId 
     * @param session 
     * @return attributes
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
   public Collection<Attribute> getAttributesByNode( Long processId, Long nodeId, Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select a from Attribute a where " +
               "a.process.id=:processId and a.node.id=:nodeId";
        Query query = session.createQuery(hql);
        query.setParameter("processId", processId);
        query.setParameter("nodeId", nodeId);
        Collection<Attribute> list = (Collection<Attribute>)query.list(); 
        QueryLogger qlogger=new QueryLogger();
        logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
        logger.info("ends");
        return list;
    }

    
}

