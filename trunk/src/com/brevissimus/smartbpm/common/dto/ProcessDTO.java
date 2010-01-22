package com.brevissimus.smartbpm.common.dto;

import java.io.Serializable;
import java.util.Collection;

import com.brevissimus.smartbpm.common.dto.NodeDTO;
import com.brevissimus.smartbpm.common.dto.ProcessTypeDTO;
import com.brevissimus.smartbpm.common.dto.UserDTO;

/**
 *<p>ProcessDTO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.29.</p>
 */

public class ProcessDTO implements Serializable {
            
    private static final long serialVersionUID = 1976405442245629007L;

    private Long id;
    private String name;
    private String description;
    private UserDTO user;
    private ProcessTypeDTO processType;
    private NodeDTO actualNode;
    private Collection<NodeDTO> nodes;
        
    /**
     * Default constructor
     */
    public ProcessDTO() {
        super();
    }

    /**
     * Full constructor
     * 
     * @param name
     * @param description
     * @param user
     * @param processType
     * @param node
     */
    public ProcessDTO( String name, String description, UserDTO user, ProcessTypeDTO processType, NodeDTO actualNode) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.processType = processType;
        this.setActualNode(actualNode);
    }
        
    /** 
     * minimal constructor
     * 
     * @param name
     * @param user
     * @param processType
     */
    public ProcessDTO( String name, UserDTO user, ProcessTypeDTO processType) {
        this.name = name;
        this.user = user;
        this.processType = processType;
    }
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
     * Getter for property <code>user</code>.
     * @return Value of <code>user</code>.
     */
    public UserDTO getUser() {
        return user;
    }
    /**
     * Setter for property <code>user</code>.
     * @param user new value of <code>user</code>.
     */
    public void setUser(UserDTO user) {
        this.user = user;
    }

    /**
     * Getter for property <code>node</code>.
     * @return Value of <code>node</code>.
     */   
    public Collection<NodeDTO> getNodes() {
        return nodes;
    }

    /**
     * Setter for property <code>nodes</code>.
     * @param nodes new value of <code>nodes</code>.
     */
    public void setNodes(Collection<NodeDTO> nodes) {
        this.nodes = nodes;
    }
    
    /**
     * Setter for property <code>actualNode</code>.
     * @param actualNode new value of <code>actualNode</code>.
     */
    public void setActualNode(NodeDTO actualNode) {
        this.actualNode = actualNode;
    }

    
    /**
     * Getter for property <code>actualNode</code>.
     * @return Value of <code>actualNode</code>.
     */
    public NodeDTO getActualNode() {
        return actualNode;
    }
 
    
    /**
     * Setter for property <code>processType</code>.
     * @param processType new value of <code>processType</code>.
     */
    public void setProcessType(ProcessTypeDTO processType) {
        this.processType = processType;
    }
    
    /**
     * Getter for property <code>processType</code>.
     * @return Value of <code>processType</code>.
     */
    public ProcessTypeDTO getProcessType() {
        return processType;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessDTO[id=" + id + ",")
          .append("name='" + name + "',")
          .append("description='" + description + "',");
         if (actualNode != null){
             sb.append("actualNode='" + actualNode.getState().getName() + "',");
         }
        sb.append("processType='" + processType.getName() + "',");
        if (nodes != null) {
            sb.append("nodes=[");
            for (NodeDTO node : nodes) {
                sb.append(node+",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("],");
        }
        sb.append("user='" + user + "']");
        return sb.toString();
    }    
}
