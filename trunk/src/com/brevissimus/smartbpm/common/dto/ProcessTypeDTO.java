package com.brevissimus.smartbpm.common.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 *<p>ProcessTypeDTO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.29.</p>
 */

public class ProcessTypeDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Collection<NodeDTO> nodes;

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
     * Getter for property <code>name</code>.
     * @return Value of <code>name</code>.
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for property <code>name</code>.
     * @param name new value of <code>name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for property <code>description</code>.
     * @return Value of <code>description</code>.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Setter for property <code>description</code>.
     * @param description new value of <code>description</code>.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for property <code>nodes</code>.
     * @param nodes new value of <code>nodes</code>.
     */
    public void setNodes(Collection<NodeDTO> nodes) {
        this.nodes = nodes;
    }
    
    /**
     * Getter for property <code>nodes</code>.
     * @return Value of <code>nodes</code>.
     */
    public Collection<NodeDTO> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();           
        sb.append("ProcessTypeDTO[id="+id+",")
          .append("name='"+name+"'");
        if (this.nodes!=null){
            sb.append(",nodes=[");
            for (NodeDTO node: this.getNodes()) {
                sb.append(node.toString()+",");
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }   
}