package com.brevissimus.smartbpm.common.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 *<p>NodeDTO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.07.01.</p>
 */


public class NodeDTO implements Serializable {

    private Long id;
    private Collection<AttributeDTO> attributes;
    private StateDTO state;
    
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    public Long getId() {
        return id;
    } 
    
    /**
     * Setter for property <code>id</code>.
     * @param id new value of <code>id</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
 
    /**
     * Getter for property <code>attributes</code>.
     * @return Value of <code>attributes</code>.
     */
    public Collection<AttributeDTO> getAttributes() {
        return attributes;
    }
    /**
     * Getter for property <code>state</code>.
     * @return Value of <code>state</code>.
     */
    public StateDTO getState() {
        return state;
    }
    /**
     * Setter for property <code>attributes</code>.
     * @param attributes new value of <code>attributes</code>.
     */
    public void setAttributes(Collection<AttributeDTO> attributes) {
        this.attributes = attributes;
    }
    /**
     * Setter for property <code>state</code>.
     * @param state new value of <code>state</code>.
     */
    public void setState(StateDTO state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NodeDTO[")
          .append("id=" +id)
          .append(",state=" + state);
        if (attributes!=null) {
            sb.append(",\nattributes=[");
            for (AttributeDTO attribute : attributes) {
                sb.append( attribute+",\n");
            }
            sb.deleteCharAt(sb.length()-2);
        }
        sb.append("]]");
        return sb.toString();
    }
    
}

