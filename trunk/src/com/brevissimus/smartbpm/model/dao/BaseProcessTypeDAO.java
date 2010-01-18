
package com.brevissimus.smartbpm.model.dao;

// Generated 2009.07.14. 17:25:44 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.ProcessType;

/**
 * BaseDAO for domain model class ProcessType.
 * @see com.brevissimus.smartbpm.model.ProcessType
 * @author Hibernate Tools
 */
public class BaseProcessTypeDAO {
	
    private static final Log log = LogFactory.getLog(BaseProcessTypeDAO.class);

    /**
     * Persisting <Code>ProcessType</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(ProcessType transientInstance, Session session) throws HibernateException {
        log.debug("persisting ProcessType instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>ProcessType</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(ProcessType instance, Session session) throws HibernateException {
        log.debug("attaching dirty ProcessType instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>ProcessType</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(ProcessType instance, Session session) throws HibernateException {
        log.debug("attaching clean ProcessType instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>ProcessType</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(ProcessType persistentInstance, Session session) throws HibernateException {
        log.debug("deleting ProcessType instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>ProcessType</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return ProcessType
     */
    public ProcessType merge(ProcessType detachedInstance, Session session) throws HibernateException {
        log.debug("merging ProcessType instance");
        ProcessType result = (ProcessType) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>ProcessType</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return ProcessType
     */
	public ProcessType getById( Long id, Session session) throws HibernateException {
        log.debug("getting ProcessType instance with id: " + id);
        ProcessType instance = (ProcessType) session.get("com.brevissimus.smartbpm.model.ProcessType", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
