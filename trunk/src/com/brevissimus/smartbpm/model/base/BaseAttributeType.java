package com.brevissimus.smartbpm.model.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *<p>BaseAttributeType</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@MappedSuperclass
public class BaseAttributeType {
    
    // 1 - boolean
    // 2 - int
    // 3 - string
    // 4 - date
    
    protected Long id;
    protected String name;
    protected String description;
    protected int valueType;
    
    /**
     * Default constructor
     */
    public BaseAttributeType() {
    }

    /**
     * Full constructor
     * 
     * @param description
     * @param name
     * @param valueType
     */
    public BaseAttributeType(String description, String name, int valueType) {
       this.description = description;
       this.name = name;
       this.valueType = valueType;
    } 
    
    /**
     * Getter for property <code>name</code>.
     * @return Value of <code>name</code>.
     */
    @Column(length=50)
    public String getName() {
        return name;
    }
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "attribute_type_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_BBBPM")
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
    @Column(length=100)
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
     * Setter for property <code>valueType</code>.
     * @param valueType new value of <code>valueType</code>.
     */
    public void setValueType(int valueType) {
        this.valueType = valueType;
    }
    
    /**
     * Getter for property <code>valueType</code>.
     * @return Value of <code>valueType</code>.
     */
    @Column(name = "value_type")
    public int getValueType() {
        return valueType;
    }

}

