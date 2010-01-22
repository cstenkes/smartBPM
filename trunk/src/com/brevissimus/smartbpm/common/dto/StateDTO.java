package com.brevissimus.smartbpm.common.dto;

import java.io.Serializable;

// View representation of State Model Object quasi form beans in Struts

/**
 *<p>StateDTO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.22.</p>
 */


public class StateDTO implements Serializable{
 
    private static final long serialVersionUID = 1485074372035868199L;
    
    private Long id;
    private String name;
    private String description;
    
    /**
     * Default constructor
     */
    public StateDTO() {    
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StateDTO[id=" + id + ",")
          .append("name='" + name + "',")
          .append("description='" + description + "']");
        return sb.toString();
    }
}

