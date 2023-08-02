package com.brevissimus.smartbpm.dto.assembly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.brevissimus.smartbpm.model.Attribute;
import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.common.dto.AttributeDTO;

/**
 *<p>AttributeFactory</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.07.01.</p>
 */


public class AttributeFactory {

    
    /**
     * creating DTO.
     *  
     * @param attribute
     * @return attributeDTO
     */
    public static AttributeDTO createAttributeDTO(Attribute attribute) {
        AttributeDTO attributeDTO = new AttributeDTO();
        attributeDTO.setId(attribute.getId());
        attributeDTO.setName(attribute.getAttributeType().getName());
        attributeDTO.setDescription(attribute.getAttributeType().getDescription());
        //attribute.getAttributeType()
        
        if (attribute.getStringValue() != null) {
            attributeDTO.setValue(attribute.getStringValue());
        } else if (attribute.getIntValue() != null) {
            attributeDTO.setValue(attribute.getIntValue());
        } else if (attribute.getBooleanValue() != null) {
            attributeDTO.setValue(attribute.getBooleanValue());
        } else if (attribute.getDateValue() != null) {
            attributeDTO.setValue(attribute.getDateValue());
        }
        return attributeDTO;
    }

    /**
     * creating DTO.
     *  
     * @param attributeType
     * @return attributeDTO
     */
    public static AttributeDTO createAttributeDTO(AttributeType attributeType) {
        AttributeDTO attributeDTO = new AttributeDTO();
        attributeDTO.setName(attributeType.getName());
        attributeDTO.setDescription(attributeType.getDescription());
        return attributeDTO;
    }
    
    
    /**
     * creating DTO.
     * @param attributeDTO 
     * @return attributeDTO
     */
    public static Attribute createAttribute(AttributeDTO attributeDTO) {
        Attribute attribute = new Attribute();
        attribute.setId(attributeDTO.getId());
        /*attribute.setDescription(attributeDTO.getAttributeType().getDescription());
        
        if (attributeDTO.getStringValue() != null) {
            attribute.setValue(attributeDTO.getStringValue());
        } else if (attributeDTO.getIntValue() != null) {
            attributeDTO.setValue(attribute.getIntValue());
        } else if (attributeDTO.getBooleanValue() != null) {
            attributeDTO.setValue(attribute.getBooleanValue());
        } else if (attributeDTO.getDateValue() != null) {
            attributeDTO.setValue(attribute.getDateValue());
        }*/
        return attribute;
    }
    
    
    /**
     * 
     * @param attributes 
     * @param attributeTypes 
     * @return 
     */
    public static Collection<AttributeDTO> createAttributeDTOs(Collection<Attribute> attributes, Collection<AttributeType> attributeTypes) {
        Collection<AttributeDTO> attributeDTOs = new ArrayList<AttributeDTO>();
        
        HashMap<Long,Attribute> attributeHash = new HashMap<Long,Attribute>();
        if (attributes!=null){
            for (Attribute attribute : attributes) {
                attributeHash.put(attribute.getAttributeType().getId(), attribute);
            }
        }
        
        for (AttributeType attributeType : attributeTypes) {
            if (attributeHash.get(attributeType.getId())!=null) {
                attributeDTOs.add(AttributeFactory.createAttributeDTO((Attribute)attributeHash.get(attributeType.getId())));
                attributeHash.remove(attributeType.getId());
            } else {
                attributeDTOs.add(AttributeFactory.createAttributeDTO(attributeType));
            }
        }
        return attributeDTOs;
    }
    
    
}