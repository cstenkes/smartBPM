package com.brevissimus.smartbpm.dto.assembly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.brevissimus.smartbpm.common.dto.NodeDTO;
import com.brevissimus.smartbpm.common.dto.ProcessTypeDTO;
import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.ProcessType;

/**
 *<p>ProcessTypeFactory</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.07.01.</p>
 */

public class ProcessTypeFactory {

    /**
     * creating DTO.
     * 
     * @param processType
     * @return processTypeDTO
     */
    public static ProcessTypeDTO createProcessTypeDTO(ProcessType processType) {
        ProcessTypeDTO processTypeDTO = new ProcessTypeDTO();
        processTypeDTO.setId(processType.getId());
        processTypeDTO.setName(processType.getName());
        Collection<Node> nodes = processType.getNodes();
        if (nodes != null) {
            Collection<NodeDTO> nodeDTOs = new ArrayList<NodeDTO>(); 
            for(Node node: processType.getNodes()){
                nodeDTOs.add(NodeFactory.createNodeDTO(node));
            }
            processTypeDTO.setNodes(nodeDTOs);
        }
        processTypeDTO.setDescription(processType.getDescription());
        return processTypeDTO;
    }

    /**
     * creating Model object
     * 
     * @param processTypeDTO
     * @return processType
     */
    public static ProcessType createProcessType(ProcessTypeDTO processTypeDTO) {
        ProcessType processType = new ProcessType();
        processType.setId(processTypeDTO.getId());
        processType.setName(processTypeDTO.getName());
        processType.setDescription(processTypeDTO.getDescription());
        Collection<NodeDTO> nodeDTOs = processTypeDTO.getNodes();
        if (nodeDTOs != null) {
            List<Node> nodes = new ArrayList<Node>(); 
            for(NodeDTO nodeDTO: nodeDTOs){
                nodes.add(NodeFactory.createNode(nodeDTO));
            }
            processType.setNodes(nodes);
        }
        return processType;
    }
}
