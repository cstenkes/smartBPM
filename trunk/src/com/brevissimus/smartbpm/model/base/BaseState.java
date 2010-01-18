package com.brevissimus.smartbpm.model.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *<p>BaseState</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */


@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@MappedSuperclass
public class BaseState {
    protected Long id;
    protected String name;
    protected String description;
    
    /**
     * Default constructor
     */
    public BaseState() {
    }

    /**
     * Full constructor
     * 
     * @param description
     * @param name
     */
    public BaseState(String description, String name) {
       this.description = description;
       this.name = name;
    } 
    
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "state_id")
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
     * Getter for property <code>name</code>.
     * @return Value of <code>name</code>.
     */
    @Column(length=25)
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
}

