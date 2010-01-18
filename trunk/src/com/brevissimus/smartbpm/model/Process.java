/**
 * 
 */
package com.brevissimus.smartbpm.model;

import javax.persistence.Entity;

import com.brevissimus.smartbpm.model.base.BaseProcess;

/**
 *<p>Process</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@Entity
public class Process extends BaseProcess {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();           
        sb.append("Process[id="+id)
        .append(",name='"+name+"'")
        .append(",description='"+description+"'")
        .append(",user="+user)
        .append(",\nprocessType="+processType);
        if (node !=null){
            sb.append(",\nnode="+node);
        }
        sb.append("]");
        return sb.toString();
    }
    
}