package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.brevissimus.smartbpm.model.Process;
import com.brevissimus.smartbpm.model.User;
import com.brevissimus.smartbpm.common.HibernateSessionFactory;
import com.brevissimus.smartbpm.dao.UserDAO;


public class UserDAOTest extends TestCase  {

    private static final Logger logger = Logger.getLogger(UserDAOTest.class);

    private Session session;
    private UserDAO userDAO ;

   @Before 
   public void setUp() {
        session = HibernateSessionFactory.getSession();
        userDAO = new UserDAO();
   }
   
   @Test
   public void test1(){
       Collection<Process> processes = userDAO.getAllUserProcesses(new Long(1), session);
       for (Process p: processes){
           logger.info("\n"+p);
       }
       assertEquals(1, processes.size());  
 
   }
   
   @Test
   public void test2(){
       Collection<User> users = userDAO.getAllUser(session);
       for (User u: users){
           logger.info(u);
       }
       assertNotNull(users);  

   }
   
   
   @After
   public void tearDown() throws Exception {
       //session.commitTransaction();
       session.close();
   }       
}


