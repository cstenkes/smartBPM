package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brevissimus.smartbpm.model.State;
import com.brevissimus.smartbpm.model.dao.BaseStateDAO;

/**
 *<p>StateDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */

@Repository
public class StateDAO extends BaseStateDAO {
    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(StateDAO.class);
    
    /**
     * gets all AttributeTypes
     * @param session 
     * @return states
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public Collection<State> getAllStates(Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select s from State s";
        Query query = session.createQuery(hql);
        Collection<State> list = (Collection<State>)query.list();
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
    public State getByName(String name, Session session) throws HibernateException {
        logger.info("starts");
        State state;
        String hql = "select s from State s where s.name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        state = (State)query.uniqueResult();
        logger.info("ends");
        return state;
    }
}