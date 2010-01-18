package com.brevissimus.smartbpm.dao;

import java.util.Collection;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.common.HibernateSessionFactory;
import com.brevissimus.smartbpm.dao.AttributeTypeDAO;

/**
 * AttributeTypeDAO tests
 * 
 *<p>AttributeTypeDAOTest</p>
 *<p>Created by <a href="mailto:csaba.tenkes@p92.hu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.13.</p>
 */
public class AttributeTypeDAOTest extends TestCase{
    private static final Logger logger = Logger.getLogger(AttributeTypeDAOTest.class);

    private Session session;
    private AttributeTypeDAO attributeTypeDAO ;

   @Before 
   public void setUp() {
        session = HibernateSessionFactory.getSession();
        attributeTypeDAO = new AttributeTypeDAO();
   }
   
   @Test
   public void test1(){
       Collection<AttributeType> attributeTypes = attributeTypeDAO.getAllAttributeTypes(session);
       for (AttributeType at: attributeTypes){
           logger.info(at);
       }
       assertEquals(9, attributeTypes.size());  
   }

   @Test
   public void test2(){
       AttributeType attributeType = attributeTypeDAO.getById(new Long(1),session);
       logger.info(attributeType);
       assertNotNull(attributeType);  
   }

   @Test
   public void test3(){
       AttributeType attributeType = attributeTypeDAO.getByName("application url", session);
       logger.info(attributeType);
       assertNotNull(attributeType);  
   }
 
   @After
   public void tearDown() throws Exception {
       //session.commitTransaction();
       session.close();
       logger.info("---  E N D ---");
   }   
}