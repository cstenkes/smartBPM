package com.brevissimus.smartbpm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.brevissimus.smartbpm.model.base.BaseUser;

/**
 *<p>User</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@javax.persistence.SequenceGenerator(
        name="SEQ_BBBPM",
        sequenceName="SEQ_BBBPM",
        allocationSize=20
        )

@Entity
@Table(name="user_acc")
public class User extends BaseUser {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();           
        sb.append("User[id="+id)
        .append(",name='"+name+"'")
        .append(",email='"+email+"'")
        .append(",firstName="+firstName)
        .append(",lastName="+lastName)
        .append(",phone="+phone+"]");
        return sb.toString();
    }
}

