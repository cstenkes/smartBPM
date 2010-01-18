
package com.brevissimus.smartbpm.model.dao;

// Generated 2009.07.14. 17:25:44 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.Process;

/**
 * BaseDAO for domain model class Process.
 * @see com.brevissimus.smartbpm.model.Process
 * @author Hibernate Tools
 */
public class BaseProcessDAO {
	
    private static final Log log = LogFactory.getLog(BaseProcessDAO.class);

    /**
     * Persisting <Code>Process</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(Process transientInstance, Session session) throws HibernateException {
        log.debug("persisting Process instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>Process</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(Process instance, Session session) throws HibernateException {
        log.debug("attaching dirty Process instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>Process</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(Process instance, Session session) throws HibernateException {
        log.debug("attaching clean Process instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>Process</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(Process persistentInstance, Session session) throws HibernateException {
        log.debug("deleting Process instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>Process</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return Process
     */
    public Process merge(Process detachedInstance, Session session) throws HibernateException {
        log.debug("merging Process instance");
        Process result = (Process) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>Process</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return Process
     */
	public Process getById( Long id, Session session) throws HibernateException {
        log.debug("getting Process instance with id: " + id);
        Process instance = (Process) session.get("com.brevissimus.smartbpm.model.Process", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
