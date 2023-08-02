package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.brevissimus.smartbpm.model.ProcessType;
import com.brevissimus.smartbpm.common.HibernateSessionFactory;
import com.brevissimus.smartbpm.dao.ProcessTypeDAO;

public class ProcessTypeDAOTest extends TestCase{
    private static final Logger logger = Logger.getLogger(ProcessTypeDAOTest.class);

    private Session session;
    private ProcessTypeDAO processTypeDAO ;

   @Before 
   public void setUp() {
        session = HibernateSessionFactory.getSession();
        processTypeDAO = new ProcessTypeDAO();
   }
   
   @Test
   public void test1(){
       ProcessType processType = processTypeDAO.getById(new Long(1),session);
          logger.info("\n"+processType);

       assertNotNull(processType);  
   }

   @Test
   public void test2(){
       logger.info("\n test2");
       Collection<ProcessType> processTypes = processTypeDAO.getAllProcessTypes(session);
       for (ProcessType processType : processTypes) {
           logger.info("\n"+processType);
       }
       assertTrue(processTypes.size()>0);
   }
   
   @After
   public void tearDown() throws Exception {
       //session.commitTransaction();
       session.close();
   }   
}

