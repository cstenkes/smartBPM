/**
 * 
 */
package com.brevissimus.smartbpm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.brevissimus.smartbpm.model.base.BaseProcessType;

/**
 *<p>ProcessType</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.07.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@Entity
@Table(name="process_type")
public class ProcessType extends BaseProcessType{
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();           
        sb.append("ProcessType[id="+id+",")
          .append("name='"+name+"',")
          .append("description='"+description+"'");
        for (Node node: this.getNodes()) {
            sb.append(",\nnode="+node.toString());
        }
        sb.append("]");
        return sb.toString();
    }
}

