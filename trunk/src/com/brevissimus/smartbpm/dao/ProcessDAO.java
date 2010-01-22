package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.State;
import com.brevissimus.smartbpm.model.Process;
import com.brevissimus.smartbpm.model.dao.BaseProcessDAO;
import com.brevissimus.smartbpm.common.QueryLogger;
import com.brevissimus.smartbpm.common.dto.AttributeDTO;

/**
 *<p>ProcessDAO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */


@Repository
public class ProcessDAO extends BaseProcessDAO {
    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(ProcessDAO.class);
     
    /**
     * gets state of a given process
     * @param userId 
     * @param processId 
     * @param session 
     * @return state
     * @throws HibernateException
     */
     public State getState(Long userId, Long processId, Session session) throws HibernateException {
        logger.info("starts");
        String hql = "select p.node.state from User u, Process p where p.user=u and u.id=:userId and p.id=:processId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        query.setParameter("processId", processId);
        State state = (State)query.uniqueResult();
        QueryLogger qlogger=new QueryLogger();
        logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
        logger.info("ends");
        return state;
    }
     
     /**
      * gets all Attributes of a given process
      * @param userId 
      * @param processId 
      * @param session 
      * @return attributes
      * @throws HibernateException
      */
     @SuppressWarnings("unchecked")
    public Collection<Attribute> getAttributes(Long userId, Long processId, Session session) throws HibernateException {
         logger.info("starts");
         String hql = "select a from Attribute a, User u, Process p, Node n where p.user=u and u.id=:userId and p.id=:processId and a.process=p and a.node=p.node and n=p.node";
         Query query = session.createQuery(hql);
         query.setParameter("userId", userId);
         query.setParameter("processId", processId);
         Collection<Attribute> list = (Collection<Attribute>)query.list(); 
         QueryLogger qlogger=new QueryLogger();
         logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
         logger.info("ends");
         return list;
     }
     
     /**
      * gets all AttributeTypes of a given process
      * @param userId 
      * @param nodeId
      * @param processId
      * @param session 
      * @return attributeTypes
      * @throws HibernateException
      */
     @SuppressWarnings("unchecked")
    public Collection<AttributeType> getAttributeTypesByProcessAndNode(Long userId, Long nodeId, Long processId, Session session) throws HibernateException {
         logger.info("starts");
         String hql = "select pt.attributeTypes from User u, Process p, ProcessType pt, Node n where p.user=u p.processType=pt and n in (pt.nodes) and u.id=:userId and p.id=:processId and n.id=:nodeId";
         Query query = session.createQuery(hql);
         query.setParameter("userId", userId);
         query.setParameter("processId", processId);
         query.setParameter("nodeId", nodeId);
         
         Collection<AttributeType> list = query.list(); 
         QueryLogger qlogger=new QueryLogger();
         logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
         logger.info("ends");
         return list;
     }

     
     /**
      * gets all AttributeTypes of a given process
      * @param userId 
      * @param processId 
      * @param session 
      * @return attributeTypes
      * @throws HibernateException
      */
     @SuppressWarnings("unchecked")
    public Collection<AttributeType> getAttributeTypes(Long userId, Long processId, Session session) throws HibernateException {
         logger.info("starts");
         String hql = "select p.node.attributeTypes from User u, Process p, Node n where p.user=u and u.id=:userId and p.id=:processId";
         Query query = session.createQuery(hql);
         query.setParameter("userId", userId);
         query.setParameter("processId", processId);
         Collection<AttributeType> list = query.list(); 
         QueryLogger qlogger=new QueryLogger();
         logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
         logger.info("ends");
         return list;
     }
         
     /**
      * gets Node of a given process
      * @param userId 
      * @param processId 
      * @param session 
      * @return Node
      * @throws HibernateException
      */
     public Node getNode(Long userId, Long processId, Session session) throws HibernateException {
         logger.info("starts");
         String hql = "select p.node from User u, Process p, Node n where p.user=u and u.id=:userId and p.id=:processId";
         Query query = session.createQuery(hql);
         query.setParameter("userId", userId);
         query.setParameter("processId", processId);
         Node list = (Node)query.uniqueResult();
         QueryLogger qlogger=new QueryLogger();
         logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
         logger.info("ends");
         return list;
     }
     
     
     /**
      * gets all Processes existing in the system
      * 
      * @param userId 
      * @param processId 
      * @param session 
      * @return state
      * @throws HibernateException
      */
     @SuppressWarnings("unchecked")
     public Collection<Process> getAllProcesses(Session session) throws HibernateException {
         logger.info("starts");
         Collection<Process> processes;
         String hql = "select p from Process p";
         Query query = session.createQuery(hql);
         QueryLogger qlogger = new QueryLogger();
         processes = (Collection<Process>)query.list();
         logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
         logger.info("ends");
         return processes;
     }
     
     /**
      * gets all Processes existing in the system
      * 
      * @param userId 
      * @param processId 
      * @param session 
      * @return state
      * @throws HibernateException
      */
     @SuppressWarnings("unchecked")
     public Collection<Process> getAllProcessesByUser(Long userId, Session session) throws HibernateException {
         logger.info("starts");
         Collection<Process> processes;
         String hql = "select p from Process p where p.user.id=:userId";
         Query query = session.createQuery(hql);
         QueryLogger qlogger = new QueryLogger();
         query.setParameter("userId", userId);
         processes = (Collection<Process>)query.list();
         logger.info("\n"+qlogger.showQuery(session.getSessionFactory(), query));
         logger.info("ends");
         return processes;
     }
     
}