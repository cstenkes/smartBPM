package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brevissimus.smartbpm.common.QueryLogger;
import com.brevissimus.smartbpm.model.Process;
import com.brevissimus.smartbpm.model.User;
import com.brevissimus.smartbpm.model.dao.BaseUserDAO;

/**
 *<p>UserDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */

@Repository
public class UserDAO extends BaseUserDAO {

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(UserDAO.class);
    
    /**
     * gets all AttributeTypes
     * @param session 
     * @return users
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public Collection<User> getAllUser(Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select u from User u";
        Query query = session.createQuery(hql);
        Collection<User> list = (Collection<User>)query.list();
        logger.info("ends");
        return list;
    }
    
    /**
     * gets all AttributeTypes
     * @param uid User id
     * @param session 
     * @return processes
     * @throws HibernateException
     */
     @SuppressWarnings("unchecked")
    public Collection<Process> getAllUserProcesses(Long uid, Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select p from User u, Process p where p.user=u and u.id=:uid";
        Query query = session.createQuery(hql);
        query.setParameter("uid", uid);
        Collection<Process> list = (Collection<Process>)query.list();
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
    public User getByName(String name, Session session) throws HibernateException {
        logger.info("starts");
        User user;
        String hql = "select u from User u where u.name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        user = (User)query.uniqueResult();
        logger.info("ends");
        return user;
    }

    /**
     * gets an attributeType by name. Name must be unique.
     * @param name 
     * @param session 
     * @return AttributeType
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public Collection<User> getByFirstnameAndLastname(String name, Session session) throws HibernateException {
        logger.info("starts");
        Collection<User> users;
        String hql = "select u from User u where u.firstName like '%"+name+"%' or u.lastName like '%"+name+"%' or u.name like '%"+name+"%'";
        Query query = session.createQuery(hql);
        QueryLogger qlogger=new QueryLogger();
        logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
        users = (Collection<User>)query.list();
        logger.info("ends");
        return users;
    }

    /**
     * gets an attributeType by name. Name must be unique.
     * @param username 
     * @param password 
     * @param session 
     * @return AttributeType
     * @throws HibernateException
     */
    @SuppressWarnings("unchecked")
    public boolean authenticate(String username, String password, Session session) throws HibernateException {
        logger.info("starts");
        Collection<User> users;
        boolean retValue = false;
        String hql = "select u from User u where u.name = :name and u.password = :password";
        Query query = session.createQuery(hql);
        query.setString("name", username);
        query.setString("password", password);
        QueryLogger qlogger=new QueryLogger();
        logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
        users = (Collection<User>)query.list();
        if (users.size()==1){
            retValue = true;
        } else {
            retValue = false;
        }
        logger.info("ends");
        return retValue;
    }
    
    
    /**
     * <Code>User</Code> getById.
     * @param id
     * @param session 
     * @throws HibernateException     
     */
    public void removeById( Long id, Session session) throws HibernateException {
        logger.debug("getting User instance with id: " + id);
        User user = (User) session.get("com.brevissimus.smartbpm.model.User", id);
        if (user != null) {
            session.delete(user);
        } else {
            logger.debug("get successful, no instance found");
        }
    }
    
}

