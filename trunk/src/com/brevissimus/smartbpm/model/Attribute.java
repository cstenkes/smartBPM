package com.brevissimus.smartbpm.model;

import javax.persistence.Entity;

import com.brevissimus.smartbpm.model.base.BaseAttribute;

/**
 *<p>Attribute</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@Entity
public class Attribute extends BaseAttribute {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attribute[id=" + id + ",");
        if (stringValue != null) {
            sb.append("stringValue=\"" + stringValue + "\"");
        } else if (intValue != null) {
            sb.append("intValue=" + intValue);
        } else if (booleanValue != null) {
            sb.append("booleanValue=" + booleanValue);
        } else if (dateValue != null) {
            sb.append("dateValue=" + dateValue);
        }
        sb.append("]");
        return sb.toString();
    }

    
    /**
     * getting the value
     * @return
     */
 /*   public Object getValue(){        
        if (stringValue != null) {
            return stringValue;
        } else if (intValue != null) {
            return intValue;
        } else if (booleanValue != null) {
            return booleanValue;
        } else if (dateValue != null) {
            return dateValue;
        }
        return null;
    }*/
}

