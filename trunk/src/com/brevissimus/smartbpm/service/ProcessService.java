package com.brevissimus.smartbpm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brevissimus.smartbpm.common.BaseService;
import com.brevissimus.smartbpm.common.SmartBpmException;
import com.brevissimus.smartbpm.common.dto.AttributeDTO;
import com.brevissimus.smartbpm.common.dto.NodeDTO;
import com.brevissimus.smartbpm.common.dto.ProcessDTO;
import com.brevissimus.smartbpm.common.dto.StateDTO;
import com.brevissimus.smartbpm.dao.AttributeDAO;
import com.brevissimus.smartbpm.dao.NodeDAO;
import com.brevissimus.smartbpm.dao.ProcessDAO;
import com.brevissimus.smartbpm.dto.assembly.AttributeFactory;
import com.brevissimus.smartbpm.dto.assembly.ProcessFactory;
import com.brevissimus.smartbpm.dto.assembly.StateFactory;
import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.Process;
import com.brevissimus.smartbpm.model.State;

/**
 *<p>ProcessService</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.10.</p>
 */

@Service
public class ProcessService extends BaseService {
    
    private static final Log logger = LogFactory.getLog(ProcessService.class);

    // injected by spring
    private ProcessDAO processDAO;

    // injected by spring
    private AttributeDAO attributeDAO;

    /**
     * Setter for property <code>attributeDAO</code>.
     * @param attributeDAO new value of <code>attributeDAO</code>.
     */
    @Autowired
    public void setAttributeDAO(AttributeDAO attributeDAO) {
        this.attributeDAO = attributeDAO;
    }

    /**
     * Getter for property <code>attributeDAO</code>.
     * @return Value of <code>attributeDAO</code>.
     */
    public AttributeDAO getAttributeDAO() {
        return attributeDAO;
    }
    
    /**
     * Setter for property <code>processDAO</code>.
     * @param processDAO new value of <code>processDAO</code>.
     */
    @Autowired 
    public void setProcessDAO(ProcessDAO processDAO) {
        this.processDAO = processDAO;
    }

    /**
     * Getter for property <code>processDAO</code>.
     * @return Value of <code>processDAO</code>.
     */
    public ProcessDAO getProcessDAO() {
        return processDAO;
    }

    
    /**
     * gets the state of process
     * 
     * @param userId
     * @param processId
     * @return StateDTO
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public StateDTO getProcessState(Long userId, Long processId) throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("getting the state of process");
            /*if (true) { // For testing exception handling
                throw new HibernateException("SmartBPM example for rollback");
            }*/    
            State state = processDAO.getState(userId, processId, session);
            StateDTO stateDTO = StateFactory.createStateDTO(state);     
            return stateDTO;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
            throw new SmartBpmException(ex,"rollback is needed");

        }
    }
 
    /**
     * gets all the attribute of process
     * 
     * @param userId
     * @param processId
     * @return AttributeDTOs
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public Collection<AttributeDTO> getProcessAttributes(Long userId, Long processId) throws SmartBpmException {
        logger.debug("getting all the attribute of process");
        Session session = getCurrentSession();
        try {
            Collection<Attribute> attributes = processDAO.getAttributes(userId, processId, session);
            
            //assembling the return values
            Collection<AttributeDTO> attributeDTOs = new ArrayList<AttributeDTO>();
            for (Attribute attribute : attributes) {
                attributeDTOs.add(AttributeFactory.createAttributeDTO(attribute));
            }

            return attributeDTOs;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be thrown from here 
            throw new SmartBpmException(ex,"rollback is needed");
        }
    }
    
    /**
     * gets actual node of the process
     * 
     * @param userId
     * @param processId
     * @return NodeDTO
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public NodeDTO getProcessNode(Long userId, Long processId) throws SmartBpmException {
        logger.debug("getting the state of process");
        Session session = getCurrentSession();
        try {
            Collection<Attribute> attributes = processDAO.getAttributes(userId, processId, session);
            State state = processDAO.getState(userId, processId, session);
            
            //assembling the return values
            Collection<AttributeDTO> attributeDTOs = new ArrayList<AttributeDTO>();
            for (Attribute attribute : attributes) {
                attributeDTOs.add(AttributeFactory.createAttributeDTO(attribute));
            }
            StateDTO stateDTO = StateFactory.createStateDTO(state);
            NodeDTO nodeDTO = new NodeDTO();
            nodeDTO.setState(stateDTO);
            nodeDTO.setAttributes(attributeDTOs);          
            
            return nodeDTO;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be thrown from here 
            throw new SmartBpmException(ex,"rollback is needed");
        }
    }
    
    /**
     * is process started
     * 
     * @param userId
     * @param processId
     * @return true / false
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public Boolean isProcessStarted(Long userId, Long processId) throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("is process started");
            return ((processDAO.getState(userId, processId, session)!=null)?(new Boolean(processDAO.getState(userId, processId, session)!=null)):null);
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be thrown from here 
            throw new SmartBpmException(ex,"rollback is needed");
        }
    }
    
    /**
     * getting all the Processes
     * 
     * @param userId
     * @param processId
     * @return StateDTO
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public List<ProcessDTO> findAll() throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("getting all the Processes");
            Collection<Process> processes = processDAO.getAllProcesses(session);            
            List<ProcessDTO> processDTOs = new ArrayList<ProcessDTO>() ;
            for (Process process : processes) {
                // Quick fix!!! We need a better solution for avoid n+1 select problem!
                Map<Node,Collection<AttributeDTO>> attributes = new HashMap<Node,Collection<AttributeDTO>>();
                List<Node> nodes = process.getProcessType().getNodes();
                
                logger.info("PROCESS_TYPE:"+process.getProcessType());
                for (Node node : nodes) {
                    Collection<AttributeType> attributesTypes = node.getAttributeTypes();
                    Collection<Attribute> attrib = attributeDAO.getAttributesByProcessAndNode(process.getId(),node.getId(), session);
                    
                    attributes.put(node, AttributeFactory.createAttributeDTOs(attrib,attributesTypes));
                }
                ProcessDTO procesDTO = ProcessFactory.createProcessDTOMixed(process, attributes);
                processDTOs.add(procesDTO);
                logger.info(procesDTO);
            }     
            return processDTOs;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be thrown from here 
            throw new SmartBpmException(ex,"rollback is needed");
        }
    }
    
    /**
     * getting all the Processes
     * 
     * @param userId
     * @param processId
     * @return StateDTO
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public List<ProcessDTO> findAllByUser(Long userId) throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("getting all the Processes of userid"+userId);
            Collection<Process> processes = processDAO.getAllProcessesByUser(userId, session);            
            List<ProcessDTO> processDTOs = new ArrayList<ProcessDTO>() ;
            for (Process process : processes) {
                // Quick fix!!! We need a better solution for avoid n+1 select problem!
                Map<Node,Collection<AttributeDTO>> attributeMap = new HashMap<Node,Collection<AttributeDTO>>();
                List<Node> nodes = process.getProcessType().getNodes(); // hql
                for (Node node : nodes) {
                    // hql:
                    Collection<AttributeType> attributesTypes = node.getAttributeTypes(); 
                    Collection<Attribute> attribute = attributeDAO.getAttributesByProcessAndNode(process.getId(),node.getId(), session);
                    attributeMap.put(node, AttributeFactory.createAttributeDTOs(attribute,attributesTypes));
                }
                ProcessDTO procesDTO = ProcessFactory.createProcessDTOMixed(process, attributeMap);
                processDTOs.add(procesDTO);
                logger.info(procesDTO);
            }     
            return processDTOs;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be thrown from here 
            throw new SmartBpmException(ex,"rollback is needed");
        }
    }
}