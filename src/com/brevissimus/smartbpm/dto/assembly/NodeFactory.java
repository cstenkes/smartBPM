package com.brevissimus.smartbpm.dto.assembly;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.brevissimus.smartbpm.common.dto.AttributeDTO;
import com.brevissimus.smartbpm.common.dto.NodeDTO;
import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.model.Node;

/**
 *<p>AttributeFactory</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.30.</p>
 */


public class NodeFactory {
    private static final Log logger = LogFactory.getLog(NodeFactory.class);

    /**
     * creating DTO. 
     * @param node 
     * @return nodeDTO
     */
    public static NodeDTO createNodeDTO(Node node) {
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setId(node.getId());
        nodeDTO.setState(StateFactory.createStateDTO(node.getState()));
        if (node.getAttributeTypes() != null){
            Collection<AttributeDTO> attributeDTOs = new ArrayList<AttributeDTO>();
            for (AttributeType attributeType  : node.getAttributeTypes()) {
                attributeDTOs.add(AttributeFactory.createAttributeDTO(attributeType));
            }
            nodeDTO.setAttributes(attributeDTOs);
        }
        return nodeDTO;
    }

    /**
     * creating DTO. 
     * @param node 
     * @param attributes 
     * @return nodeDTO
     */
    public static NodeDTO createNodeDTO(Node node, Collection<Attribute> attributes) {
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setId(node.getId());
        nodeDTO.setState(StateFactory.createStateDTO(node.getState()));
        if (attributes != null){
            Collection<AttributeDTO> attributeDTOs = new ArrayList<AttributeDTO>();
            for (Attribute attribute : attributes) {
                attributeDTOs.add(AttributeFactory.createAttributeDTO(attribute));
            }
            nodeDTO.setAttributes(attributeDTOs);
        }
        return nodeDTO;
    }

    /**
     * creating DTO. 
     * @param node 
     * @param attributes 
     * @return nodeDTO
     */
    public static NodeDTO createNodeDTOMixed(Node node, Collection<AttributeDTO> attributes) {
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setId(node.getId());
        nodeDTO.setState(StateFactory.createStateDTO(node.getState()));
        nodeDTO.setAttributes(attributes);
        return nodeDTO;
    }

    
    
    
    /**
     * creating Model object
     * @param nodeDTO 
     * @return node
     */
    public static Node createNode(NodeDTO nodeDTO) {
        Node node = new Node();
        node.setId(nodeDTO.getId());
        node.setState(StateFactory.createState(nodeDTO.getState()));
        return node;
    }
}

