package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brevissimus.smartbpm.common.QueryLogger;
import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.dao.BaseAttributeDAO;

/**
 *<p>AttributeDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */


@Repository
public class AttributeDAO extends BaseAttributeDAO {
    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(AttributeDAO.class);

    
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
   public Collection<Attribute> getAttributesByProcessAndNode( Long processId, Long nodeId, Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select a from Attribute a where " +
               "a.process.id=:processId and a.node.id=:nodeId order by a.order";
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

