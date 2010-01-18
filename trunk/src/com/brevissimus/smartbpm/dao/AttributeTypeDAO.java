package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.model.dao.BaseAttributeTypeDAO;
import com.brevissimus.smartbpm.common.QueryLogger;

/**
 *<p>AttributeTypeDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */

@Repository
public class AttributeTypeDAO extends BaseAttributeTypeDAO {
    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(AttributeTypeDAO.class);
    
    /**
     * gets all AttributeTypes
     * @param session 
     * @return attributeTypes
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public Collection<AttributeType> getAllAttributeTypes(Session session) throws HibernateException {
        logger.info("starts");
        String hql = "from AttributeType";
        Query query = session.createQuery(hql);  
        Collection<AttributeType> list = (Collection<AttributeType>)query.list();
        logger.info("ends");
        return list;
    }
    
    /**
     * gets an attributeType by name. Name must be unique.
     * @param name 
     * @param session 
     * @return AttributeType
     * @throws HibernateException
     */
    public AttributeType getByName(String name, Session session) throws HibernateException {
        logger.info("starts");
        AttributeType attrType;
        String hql = "select a from AttributeType a where a.name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        attrType = (AttributeType)query.uniqueResult();
        QueryLogger qlogger=new QueryLogger();
        logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
        logger.info("ends");
        return attrType;
    }


    /**
     * gets an attributeType by name. Name must be unique.
     * @param name 
     * @param session 
     * @return AttributeType
     * @throws HibernateException
     */
    public AttributeType getAllAttributesByProcessAndNode(String name, Session session) throws HibernateException {
        logger.info("starts");
        AttributeType attrType;
        String hql = "select a from AttributeType a where a.name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        attrType = (AttributeType)query.uniqueResult();
        QueryLogger qlogger=new QueryLogger();
        logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
        logger.info("ends");
        return attrType;
    }


}

