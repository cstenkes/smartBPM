package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.State;
import com.brevissimus.smartbpm.common.HibernateSessionFactory;
import com.brevissimus.smartbpm.dao.ProcessDAO;

public class ProcessDAOTest extends TestCase {

    private static final Logger logger = Logger.getLogger(ProcessDAOTest.class);

    private Session session;
    private ProcessDAO processDAO ;

   @Before 
   public void setUp() {
        session = HibernateSessionFactory.getSession();
        processDAO = new ProcessDAO();
   }
   
   @Test
   public void test1(){
       State state = processDAO.getState(new Long(1),new Long(1), session);
       logger.info(state);
       assertNotNull(state);  
   }
   
   @Test
   public void test2(){
       Collection<Attribute> attributes = processDAO.getAttributes(new Long(1),new Long(1), session);
       for (Attribute attribute : attributes) {
           logger.info(attribute);
       }
       assertNotNull(attributes);  
   }
   
   @After
   public void tearDown() throws Exception {
       //session.commitTransaction();
       session.close();
   }       
}

