/**  
 * 
 */
package com.brevissimus.smartbpm.client;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.brevissimus.smartbpm.common.HibernateSessionFactory;
import com.brevissimus.smartbpm.dao.AttributeTypeDAO;

/**
 *<p>SmartBPMMain</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.14.</p>
 */

public class SmartBPMMain {
    private static final Logger logger = Logger.getLogger(SmartBPMMain.class);

    private Session session;
    private AttributeTypeDAO attributeTypeDAO ;
    
    public SmartBPMMain() {
        logger.info("SmartBPM client application is starting!");
        session = HibernateSessionFactory.getSession();
        
        //Service calls
        
        session.close();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        new SmartBPMMain();
    }

}

