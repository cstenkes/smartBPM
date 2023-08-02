
package com.brevissimus.smartbpm.model.dao;

// Generated 2010.01.22. 15:17:55 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.Attribute;

/**
 * BaseDAO for domain model class Attribute.
 * @see com.brevissimus.smartbpm.model.Attribute
 * @author Hibernate Tools
 */
public class BaseAttributeDAO {
	
    private static final Log log = LogFactory.getLog(BaseAttributeDAO.class);

    /**
     * Persisting <Code>Attribute</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(Attribute transientInstance, Session session) throws HibernateException {
        log.debug("persisting Attribute instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>Attribute</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(Attribute instance, Session session) throws HibernateException {
        log.debug("attaching dirty Attribute instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>Attribute</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(Attribute instance, Session session) throws HibernateException {
        log.debug("attaching clean Attribute instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>Attribute</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(Attribute persistentInstance, Session session) throws HibernateException {
        log.debug("deleting Attribute instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>Attribute</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return Attribute
     */
    public Attribute merge(Attribute detachedInstance, Session session) throws HibernateException {
        log.debug("merging Attribute instance");
        Attribute result = (Attribute) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>Attribute</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return Attribute
     */
	public Attribute getById( Long id, Session session) throws HibernateException {
        log.debug("getting Attribute instance with id: " + id);
        Attribute instance = (Attribute) session.get("com.brevissimus.smartbpm.model.Attribute", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
