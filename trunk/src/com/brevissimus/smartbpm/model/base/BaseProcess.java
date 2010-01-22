package com.brevissimus.smartbpm.model.base;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.ProcessType;
import com.brevissimus.smartbpm.model.User;

/**
 *<p>BaseProcess</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */


@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )
        
@MappedSuperclass
abstract public class BaseProcess {
    protected Long id;
    protected String name;
    protected String description;
    protected User user;
    protected ProcessType processType;
    protected Node node;
      
    /**
     * Default constructor
     */
    public BaseProcess() {
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
    public BaseProcess( String name, String description, User user, ProcessType processType, Node node) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.processType = processType;
        this.node = node;
    }
    
    /** 
     * minimal constructor
     * 
     * @param name
     * @param user
     * @param processType
     */
    public BaseProcess( String name, User user, ProcessType processType) {
        this.name = name;
        this.user = user;
        this.processType = processType;
    }
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "process_id")
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
    /**
     * Getter for property <code>user</code>.
     * @return Value of <code>user</code>.
     */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="useracc_id",nullable=false)
    public User getUser() {
        return user;
    }
    /**
     * Setter for property <code>user</code>.
     * @param user new value of <code>user</code>.
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Getter for property <code>node</code>.
     * @return Value of <code>node</code>.
     */   
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="node_id",nullable=true)
    public Node getNode() {
        return node;
    }
    /**
     * Setter for property <code>node</code>.
     * @param node new value of <code>node</code>.
     */
    public void setNode(Node node) {
        this.node = node;
    }
 
    
    /**
     * Setter for property <code>processType</code>.
     * @param processType new value of <code>processType</code>.
     */
    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }
    
    /**
     * Getter for property <code>processType</code>.
     * @return Value of <code>processType</code>.
     */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="process_type_id",nullable=false)
    public ProcessType getProcessType() {
        return processType;
    }

}

