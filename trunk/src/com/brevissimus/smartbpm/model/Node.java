package com.brevissimus.smartbpm.model;

import javax.persistence.Entity;

import com.brevissimus.smartbpm.model.base.BaseNode;

/**
 *<p>Node</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@Entity
public class Node extends BaseNode{
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node[id="+id+",")
        .append("state="+state+",")
        .append("validFrom="+validFrom)
        .append("]");
        return sb.toString();
    }
}