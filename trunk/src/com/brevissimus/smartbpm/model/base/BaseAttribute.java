package com.brevissimus.smartbpm.model.base;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.Process;

/**
 *<p>BaseAttribute</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 *
 */


@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@MappedSuperclass
public class BaseAttribute {
    protected Long id;
    
    protected Node node;
    protected Process process;
    protected AttributeType attributeType;
    protected Integer order;

    protected String stringValue;
    protected Integer intValue;
    protected Boolean booleanValue;
    protected Date dateValue;
    
    /**
     * Default constructor
     */
    public BaseAttribute() {
    }

    /**
     * Minimal constructor
     * 
     * @param attributeType
     * @param booleanValue
     * @param intValue
     * @param node
     * @param order
     */
    public BaseAttribute(AttributeType attributeType, Boolean booleanValue, Integer intValue, Node node, Integer order) {
        this.attributeType = attributeType;
        this.booleanValue = booleanValue;
        this.intValue = intValue;
        this.node = node;
        this.order = order;
    }
    /**
     * Full constructor
     * @param attributeType
     * @param booleanValue
     * @param intValue
     * @param node
     * @param order
     * @param process
     * @param stringValue
     */
    public BaseAttribute(AttributeType attributeType, Boolean booleanValue, Integer intValue, Node node, int order, Process process, String stringValue) {
       this.attributeType = attributeType;
       this.booleanValue = booleanValue;
       this.intValue = intValue;
       this.node = node;
       this.order = order;
       this.process = process;
       this.stringValue = stringValue;
    } 
    
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "attribute_id", nullable = false)
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
     * Getter for property <code>stringValue</code>.
     * @return Value of <code>stringValue</code>.
     */
    @Column(name = "string_value", nullable = true)
    public String getStringValue() {
        return stringValue;
    }
    /**
     * Setter for property <code>stringValue</code>.
     * @param stringValue new value of <code>stringValue</code>.
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    /**
     * Getter for property <code>intValue</code>.
     * @return Value of <code>intValue</code>.
     */
    @Column(name = "int_value",nullable = true)
    public Integer getIntValue() {
        return intValue;
    }
    /**
     * Setter for property <code>intValue</code>.
     * @param intValue new value of <code>intValue</code>.
     */
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
    /**
     * Getter for property <code>booleanValue</code>.
     * @return Value of <code>booleanValue</code>.
     */
    @Column(name = "boolean_value", nullable = true)
    public Boolean getBooleanValue() {
        return booleanValue;
    }
    /**
     * Setter for property <code>booleanValue</code>.
     * @param booleanValue new value of <code>booleanValue</code>.
     */
    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
    
    /**
     * Setter for property <code>attributeType</code>.
     * @param attributeType new value of <code>attributeType</code>.
     */
    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }
    
    /**
     * Getter for property <code>attributeType</code>.
     * @return Value of <code>attributeType</code>.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_type_id", nullable = false) 
    public AttributeType getAttributeType() {
        return attributeType;
    }
    
    /**
     * Setter for property <code>process</code>.
     * @param process new value of <code>process</code>.
     */
    public void setProcess(Process process) {
        this.process = process;
    }
    
    /**
     * Getter for property <code>process</code>.
     * @return Value of <code>process</code>.
     */
    @ManyToOne
    @JoinColumn(name="process_id")
    public Process getProcess() {
        return process;
    }
    
    /**
     * Setter for property <code>node</code>.
     * @param node new value of <code>node</code>.
     */
    public void setNode(Node node) {
        this.node = node;
    }
    
    /**
     * Getter for property <code>node</code>.
     * @return Value of <code>node</code>.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id", nullable = false)
    public Node getNode() {
        return node;
    }
    /**
     * Getter for property <code>order</code>.
     * @return Value of <code>order</code>.
     */
    @Column(name = "order_by")
    public Integer getOrder() {
        return order;
    }
    /**
     * Setter for property <code>order</code>.
     * @param order new value of <code>order</code>.
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * Getter for property <code>dateValue</code>.
     * @return Value of <code>dateValue</code>.
     */
    @Column(name = "date_value")
    public Date getDateValue() {
        return dateValue;
    }

    /**
     * Setter for property <code>dateValue</code>.
     * @param dateValue new value of <code>dateValue</code>.
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
     
}

