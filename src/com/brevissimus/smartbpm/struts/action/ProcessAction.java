package com.brevissimus.smartbpm.struts.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brevissimus.smartbpm.common.SmartBpmException;
import com.brevissimus.smartbpm.common.dto.ProcessDTO;
import com.brevissimus.smartbpm.service.ProcessService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 *<p>ProcessAction</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.29.</p>
 */

public class ProcessAction implements Preparable{
    private static final Logger logger = Logger.getLogger(ProcessAction.class);

    ProcessService processService;
    private List<ProcessDTO> processes;
    private ProcessDTO process;
    private Long id;
    private String searchText;
    
    public ProcessAction() {
        try {
           ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
           processService = (ProcessService)context.getBean("processService");
        } catch (Exception e) {
            logger.fatal("xxxxxxxxxxxxxxxxxxxxxxxx Cannot initialize Spring Application Context: "+e, e);
        }
    }

    
    /**
     * init
     */
    public void prepare() throws Exception {
        try {
            this.setProcesses(processService.findAll());
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Struts2 action
     * @return
     */
    public String execute() {
        try {
            logger.info("inside execute");
            this.setProcesses(processService.findAll());
            logger.info("end of execute");
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }

    /**
     * Setter for property <code>process</code>.
     * @param process new value of <code>process</code>.
     */
    public void setProcess(ProcessDTO process) {
        this.process = process;
    }
    
    /**
     * Getter for property <code>process</code>.
     * @return Value of <code>process</code>.
     */
    public ProcessDTO getProcess() {
        return process;
    }


    
    /**
     * Setter for property <code>id</code>.
     * @param id new value of <code>id</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }


    
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    public Long getId() {
        return id;
    }


    
    /**
     * Setter for property <code>searchText</code>.
     * @param searchText new value of <code>searchText</code>.
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }


    
    /**
     * Getter for property <code>searchText</code>.
     * @return Value of <code>searchText</code>.
     */
    public String getSearchText() {
        return searchText;
    }


    
    /**
     * Setter for property <code>processes</code>.
     * @param processes new value of <code>processes</code>.
     */
    public void setProcesses(List<ProcessDTO> processes) {
        this.processes = processes;
    }


    
    /**
     * Getter for property <code>processes</code>.
     * @return Value of <code>processes</code>.
     */
    public List<ProcessDTO> getProcesses() {
        return processes;
    }
}

