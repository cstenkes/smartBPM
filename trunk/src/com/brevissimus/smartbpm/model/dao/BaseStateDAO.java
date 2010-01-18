
package com.brevissimus.smartbpm.model.dao;

// Generated 2009.07.14. 17:25:44 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.State;

/**
 * BaseDAO for domain model class State.
 * @see com.brevissimus.smartbpm.model.State
 * @author Hibernate Tools
 */
public class BaseStateDAO {
	
    private static final Log log = LogFactory.getLog(BaseStateDAO.class);

    /**
     * Persisting <Code>State</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(State transientInstance, Session session) throws HibernateException {
        log.debug("persisting State instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>State</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(State instance, Session session) throws HibernateException {
        log.debug("attaching dirty State instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>State</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(State instance, Session session) throws HibernateException {
        log.debug("attaching clean State instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>State</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(State persistentInstance, Session session) throws HibernateException {
        log.debug("deleting State instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>State</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return State
     */
    public State merge(State detachedInstance, Session session) throws HibernateException {
        log.debug("merging State instance");
        State result = (State) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>State</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return State
     */
	public State getById( Long id, Session session) throws HibernateException {
        log.debug("getting State instance with id: " + id);
        State instance = (State) session.get("com.brevissimus.smartbpm.model.State", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
