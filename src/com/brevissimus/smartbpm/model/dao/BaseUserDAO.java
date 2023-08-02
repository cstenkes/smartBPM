
package com.brevissimus.smartbpm.model.dao;

// Generated 2010.01.22. 15:17:55 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.User;

/**
 * BaseDAO for domain model class User.
 * @see com.brevissimus.smartbpm.model.User
 * @author Hibernate Tools
 */
public class BaseUserDAO {
	
    private static final Log log = LogFactory.getLog(BaseUserDAO.class);

    /**
     * Persisting <Code>User</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(User transientInstance, Session session) throws HibernateException {
        log.debug("persisting User instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>User</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(User instance, Session session) throws HibernateException {
        log.debug("attaching dirty User instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>User</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(User instance, Session session) throws HibernateException {
        log.debug("attaching clean User instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>User</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(User persistentInstance, Session session) throws HibernateException {
        log.debug("deleting User instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>User</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return User
     */
    public User merge(User detachedInstance, Session session) throws HibernateException {
        log.debug("merging User instance");
        User result = (User) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>User</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return User
     */
	public User getById( Long id, Session session) throws HibernateException {
        log.debug("getting User instance with id: " + id);
        User instance = (User) session.get("com.brevissimus.smartbpm.model.User", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
