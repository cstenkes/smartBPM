
package com.brevissimus.smartbpm.model.dao;

// Generated 2009.07.14. 17:25:44 by Hibernate Tools 3.2.2.GA
// template by Csaba Tenkes<csaba.tenkes@brevissimus.eu>


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;

import com.brevissimus.smartbpm.model.Node;

/**
 * BaseDAO for domain model class Node.
 * @see com.brevissimus.smartbpm.model.Node
 * @author Hibernate Tools
 */
public class BaseNodeDAO {
	
    private static final Log log = LogFactory.getLog(BaseNodeDAO.class);

    /**
     * Persisting <Code>Node</Code>.
     * @param transientInstance 
     * @param session
     * @throws HibernateException           
     */
    public void persist(Node transientInstance, Session session) throws HibernateException {
        log.debug("persisting Node instance");
        session.persist(transientInstance);
        log.debug("persist successful");
    }
    
    /**
     * Save <Code>Node</Code>.
     * @param instance
     * @param session      
     * @throws HibernateException     
     */
    public void attachDirty(Node instance, Session session) throws HibernateException {
        log.debug("attaching dirty Node instance");
        session.saveOrUpdate(instance);
        log.debug("attach successful");
    }
    
    /**
     * Unlock <Code>Node</Code>.
     * @param instance  
     * @param session 
     * @throws HibernateException     
     */
    public void attachClean(Node instance, Session session) throws HibernateException {
        log.debug("attaching clean Node instance");
        session.lock(instance, LockMode.NONE);
        log.debug("attach successful");
    }
	
    /**
     * Delete <Code>Node</Code>.
     * @param persistentInstance
     * @param session 
     * @throws HibernateException     
     */
    public void delete(Node persistentInstance, Session session) throws HibernateException {
        log.debug("deleting Node instance");
        session.delete(persistentInstance);
        log.debug("delete successful");
    }
    
    /**
     * Merge <Code>Node</Code>.
     * @param detachedInstance
     * @param session 
     * @throws HibernateException     
     * @return Node
     */
    public Node merge(Node detachedInstance, Session session) throws HibernateException {
        log.debug("merging Node instance");
        Node result = (Node) session.merge(detachedInstance);
        log.debug("merge successful");
        return result;
     }
    
    /**
     * <Code>Node</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     * @return Node
     */
	public Node getById( Long id, Session session) throws HibernateException {
        log.debug("getting Node instance with id: " + id);
        Node instance = (Node) session.get("com.brevissimus.smartbpm.model.Node", id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
    

}
