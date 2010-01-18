package com.brevissimus.smartbpm.service;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brevissimus.smartbpm.common.SmartBpmException;
import com.brevissimus.smartbpm.common.dto.NodeDTO;
import com.brevissimus.smartbpm.common.dto.StateDTO;
import com.brevissimus.smartbpm.service.ProcessService;

/**
 * 
 *<p>ProcessServiceTest</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.22.</p>
 */
public class ProcessServiceTest extends TestCase {

    private static final Logger logger = Logger.getLogger(ProcessServiceTest.class);

    private ProcessService processService;
    
    @Before
    public void setUp() {
        try {
            logger.info("XXXXXXXXXXXXXXXXXXX HELLO XXXXXXXXXXXXXXXXXXXx");
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            logger.info("XXXXXXXXXXXXXXXXXXX HELLO 00000000000XXXXXXXXXXXXXXXXXXXx");
            processService = (ProcessService)context.getBean("processService");
            logger.info("XXXXXXXXXXXXXXXXXXX HELLO2222 XXXXXXXXXXXXXXXXXXXx");
        } catch (Exception e) {
            logger.fatal("xxxxxxxxxxxxxxxxxxxxxxxx Cannot initialize Spring Application Context: "+e, e);
        }
    }
    
    @Test
    public void test1(){
        StateDTO state=null;
            try {
                logger.info("XXXXXXXXXXXXXXXXXXX HELLO 333333 XXXXXXXXXXXXXXXXXXXx");
                state = processService.getProcessState(new Long(1), new Long(1));
            } catch (SmartBpmException e) {
                logger.info("Programmatic BBBpmException occured:");
                e.printStackTrace();
            }
            logger.info("State state="+state);
            assertNull(state);
    }
    
    @Test
    public void test2(){
        Boolean started = null;
        try {
            logger.info("XXXXXXXXXXXXXXXXXXX HELLO 4444 XXXXXXXXXXXXXXXXXXXx");
            started = processService.isProcessStarted(new Long(1), new Long(1));
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("Process is started="+started);
        assertNotNull(started);
    }
 
    @Test
    public void test3(){
        NodeDTO node = null;
        try {
            logger.info("XXXXXXXXXXXXXXXXXXX HELLO 555555 XXXXXXXXXXXXXXXXXXXx");
            node = processService.getProcessNode(new Long(1), new Long(1));
        } catch (SmartBpmException e) {
           e.printStackTrace();
        }
        logger.info("Process is node="+node);
        assertNotNull(node);
    }
}

