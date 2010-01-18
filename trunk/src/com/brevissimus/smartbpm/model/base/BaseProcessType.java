package com.brevissimus.smartbpm.model.base;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import com.brevissimus.smartbpm.model.Node;
import com.brevissimus.smartbpm.model.base.NodeComaparator;

/**
 *<p>BaseProcessType</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.07.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@MappedSuperclass
public class BaseProcessType {

    protected Long id;
    protected String name;
    protected String description;
    
    protected List<Node> nodes;
    
    /**
     * Default constructor
     */
    public BaseProcessType() {
    }

    /**
     * Full constructor
     * 
     * @param description
     * @param name
     * @param nodes
     */
    public BaseProcessType(String description, String name, List<Node> nodes) {
       this.description = description;
       this.name = name;
       this.nodes = nodes;
    } 
        
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "process_type_id")
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
     * Getter for property <code>nodes</code>.
     * @return Value of <code>nodes</code>.
     */
    @ManyToMany
    @JoinTable( name="process_type_node",
       joinColumns=@JoinColumn(name="process_type_id"),
       inverseJoinColumns=@JoinColumn(name="node_id"))
    @Sort(type = SortType.COMPARATOR, comparator = NodeComaparator.class)
    public List<Node> getNodes() {
        return nodes;
    }
    /**
     * Setter for property <code>nodes</code>.
     * @param nodes new value of <code>nodes</code>.
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
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