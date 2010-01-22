package com.brevissimus.smartbpm.dto.assembly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.brevissimus.smartbpm.common.dto.AttributeDTO;
import com.brevissimus.smartbpm.common.dto.NodeDTO;
import com.brevissimus.smartbpm.common.dto.ProcessDTO;
import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.Process;
import com.brevissimus.smartbpm.model.base.NodeComaparator;

/**
 *<p>ProcessFactory</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.29.</p>
 */


// Creating DTO / ValueObject for view model, which can be different than the persistence model

// Later we can do it by BeanUtils of common
public class ProcessFactory {
    private static final Log logger = LogFactory.getLog(ProcessFactory.class);

    /**
     * creating DTO. 
     * @param process 
     * @return ProcessDTO
     */
    public static ProcessDTO createProcessDTO(Process process) {
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setId(process.getId());
        processDTO.setName(process.getName());
        processDTO.setDescription(process.getDescription());
        processDTO.setProcessType(ProcessTypeFactory.createProcessTypeDTO(process.getProcessType()));
        if (process.getNode()!=null){
            processDTO.setActualNode(NodeFactory.createNodeDTO(process.getNode()));
        }
        processDTO.setUser(UserFactory.createUserDTO(process.getUser()));
        return processDTO;
    }
    
    /**
     * creating ProcessDTO  
     * @param process 
     * @param nodes 
     * @param attributes 
     * @return ProcessDTO
     */
    public static ProcessDTO createProcessDTO(Process process, Map<Node, Collection<Attribute>> attributes ) {
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setId(process.getId());
        processDTO.setName(process.getName());
        processDTO.setDescription(process.getDescription());
        processDTO.setProcessType(ProcessTypeFactory.createProcessTypeDTO(process.getProcessType()));
        if (process.getNode()!=null){
            processDTO.setActualNode(NodeFactory.createNodeDTO(process.getNode(),attributes.get(process.getNode())));
        }
        if (attributes != null) {
            Collection<NodeDTO> nodeDTOs = new ArrayList<NodeDTO>(); 
            for (Node node: attributes.keySet()){
                NodeDTO nodeDTO = NodeFactory.createNodeDTO(node, attributes.get(node)) ;
                nodeDTOs.add(nodeDTO);
            }
            processDTO.setNodes(nodeDTOs);
        }
        
        processDTO.setUser(UserFactory.createUserDTO(process.getUser()));
        return processDTO;
    }

    /**
     * creating ProcessDTO  
     * @param process 
     * @param nodes 
     * @param attributes 
     * @return ProcessDTO
     */
    public static ProcessDTO createProcessDTOMixed(Process process, Map<Node, Collection<AttributeDTO>> attributes ) {
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setId(process.getId());
        processDTO.setName(process.getName());
        processDTO.setDescription(process.getDescription());
        processDTO.setProcessType(ProcessTypeFactory.createProcessTypeDTO(process.getProcessType()));
        if (process.getNode()!=null){
            processDTO.setActualNode(NodeFactory.createNodeDTOMixed(process.getNode(),attributes.get(process.getNode())));
        }
        if (attributes != null) {
            Collection<NodeDTO> nodeDTOs = new ArrayList<NodeDTO>();
            List<Node> keys = new ArrayList<Node>();
            for (Node node: attributes.keySet()){
                keys.add(node);
            }
            Collections.sort(keys, new NodeComaparator()) ;

            for (Node node: keys){
                NodeDTO nodeDTO = NodeFactory.createNodeDTOMixed(node, attributes.get(node)) ;
                nodeDTOs.add(nodeDTO);
            }
            processDTO.setNodes(nodeDTOs);
        }
        
        processDTO.setUser(UserFactory.createUserDTO(process.getUser()));
        return processDTO;
    }

    /**
     * creating Model object
     * @param processDTO 
     * @return Process
     */
    public static Process createProcess(ProcessDTO processDTO) {
        Process process = new Process();
        process.setId(processDTO.getId());
        process.setProcessType(ProcessTypeFactory.createProcessType(processDTO.getProcessType()));
        process.setName(processDTO.getName());
        process.setDescription(processDTO.getDescription());
        process.setUser(UserFactory.createUser(processDTO.getUser()));
        return process;
    }
}