package com.brevissimus.smartbpm.common.dto;

import java.io.Serializable;

/**
 *<p>AttributeDTO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.07.07.</p>
 */

public class AttributeTypeDTO implements Serializable {
 
    private static final long serialVersionUID = -3385811599748108508L;

    private Long id;
    private String name;
    private String description;
    private int attributeType;
    private Object value;
    
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
     * Getter for property <code>description</code>.
     * @return Value of <code>description</code>.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for property <code>attributeType</code>.
     * @return Value of <code>attributeType</code>.
     */
    public int getAttributeType() {
        return attributeType;
    }

    /**
     * Getter for property <code>value</code>.
     * @return Value of <code>value</code>.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Getter for property <code>serialVersionUID</code>.
     * @return Value of <code>serialVersionUID</code>.
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Setter for property <code>name</code>.
     * @param name new value of <code>name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for property <code>description</code>.
     * @param description new value of <code>description</code>.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for property <code>attributeType</code>.
     * @param attributeType new value of <code>attributeType</code>.
     */
    public void setAttributeType(int attributeType) {
        this.attributeType = attributeType;
    }

    /**
     * Setter for property <code>value</code>.
     * @param value new value of <code>value</code>.
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeDTO[id=" + id + ",")
          .append("name='" + name + "',")
          .append("description='" + description + "',")
          .append("value='" + value + "']");
        return sb.toString();
    }  
}