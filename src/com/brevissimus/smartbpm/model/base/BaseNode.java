package com.brevissimus.smartbpm.model.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.brevissimus.smartbpm.model.AttributeType;
import com.brevissimus.smartbpm.model.State;

/**
 *<p>BaseNode</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */


@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )
        
@MappedSuperclass
public class BaseNode {
    protected Long id;
    protected State state;
    protected Collection<AttributeType> attributeTypes = new ArrayList<AttributeType>(0); 
    protected int order;
    protected Date validFrom; 
    
    /**
     * Default constructor
     */
    public BaseNode() {
    }
    
    /**
     * Minimal constructor
     * 
     * @param order
     * @param state
     */
    public BaseNode(int order, State state) {
        this.order = order;
        this.state = state;
    }
    
    /**
     * Full constructor
     * 
     * @param attributeTypes
     * @param order
     * @param state
     */
    public BaseNode(Collection<AttributeType> attributeTypes, int order, State state) {
       this.attributeTypes = attributeTypes;
       this.order = order;
       this.state = state;
    } 
    
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "node_id")
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
     * Getter for property <code>state</code>.
     * @return Value of <code>state</code>.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id", nullable = false)
    public State getState() {
        return state;
    }
    /**
     * Setter for property <code>state</code>.
     * @param state new value of <code>state</code>.
     */
    public void setState(State state) {
        this.state = state;
    }
    
    /**
     * Getter for property <code>order</code>.
     * @return Value of <code>order</code>.
     */
    @Column(name = "order_by")
    public int getOrder() {
        return order;
    }

    /**
     * Setter for property <code>order</code>.
     * @param order new value of <code>order</code>.
     */
    public void setOrder(int order) {
        this.order = order;
    }
    
    /**
     * Setter for property <code>attributeTypes</code>.
     * @param attributeTypes new value of <code>attributeTypes</code>.
     */
    public void setAttributeTypes(Collection<AttributeType> attributeTypes) {
        this.attributeTypes = attributeTypes;
    }
    
    /**
     * Getter for property <code>attributeTypes</code>.
     * @return Value of <code>attributeTypes</code>.
     */
    @ManyToMany 
    @JoinTable( name="node_attribute_type",
        joinColumns = @JoinColumn(name="node_id",unique=false), 
        inverseJoinColumns = @JoinColumn(name="attribute_type_id",unique=false))
    public Collection<AttributeType> getAttributeTypes() {
        return attributeTypes;
    }

    /**
     * Getter for property <code>validFrom</code>.
     * @return Value of <code>validFrom</code>.
     */
    @Column(name="valid_from")
    public Date getValidFrom() {
        return validFrom;
    }

    /**
     * Setter for property <code>validFrom</code>.
     * @param validFrom new value of <code>validFrom</code>.
     */
    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
}