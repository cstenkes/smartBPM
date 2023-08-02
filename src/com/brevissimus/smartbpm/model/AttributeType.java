package com.brevissimus.smartbpm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.brevissimus.smartbpm.model.base.BaseAttributeType;

/**
 *<p>AttributeType</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@Entity
@Table(name="attribute_type")
public class AttributeType extends BaseAttributeType {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeType[id="+id)
        .append(",name='"+name+"',")
        .append("description='"+description+"',")
        .append("valueType='"+valueType+"'")
        .append("]");
        return sb.toString();
    }
}

