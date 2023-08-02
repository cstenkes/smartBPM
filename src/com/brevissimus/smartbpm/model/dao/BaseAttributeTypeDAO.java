
package com.brevissimus.smartbpm.model.dao;

// Generated 2010.01.22. 15:17:55 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.AttributeType;

/**
 * BaseDAO for domain model class AttributeType.
 * @see com.brevissimus.smartbpm.model.AttributeType
 * @author Hibernate Tools
 */
public class BaseAttributeTypeDAO {
	
    private static final Log log = LogFactory.getLog(BaseAttributeTypeDAO.class);

    /**
     * Persisting <Code>AttributeType</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(AttributeType transientInstance, Session session) throws HibernateException {
        log.debug("persisting AttributeType instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>AttributeType</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(AttributeType instance, Session session) throws HibernateException {
        log.debug("attaching dirty AttributeType instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>AttributeType</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(AttributeType instance, Session session) throws HibernateException {
        log.debug("attaching clean AttributeType instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>AttributeType</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(AttributeType persistentInstance, Session session) throws HibernateException {
        log.debug("deleting AttributeType instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>AttributeType</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return AttributeType
     */
    public AttributeType merge(AttributeType detachedInstance, Session session) throws HibernateException {
        log.debug("merging AttributeType instance");
        AttributeType result = (AttributeType) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>AttributeType</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return AttributeType
     */
	public AttributeType getById( Long id, Session session) throws HibernateException {
        log.debug("getting AttributeType instance with id: " + id);
        AttributeType instance = (AttributeType) session.get("com.brevissimus.smartbpm.model.AttributeType", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
