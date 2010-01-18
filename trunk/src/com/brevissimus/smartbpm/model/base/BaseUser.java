package com.brevissimus.smartbpm.model.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

/**
 *<p>BaseUser</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.06.</p>
 */

@MappedSuperclass
public class BaseUser {
    protected Long id;
    protected String name;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;
    
    /**
     * Default constructor
     */
    public BaseUser() {
    }

    /**
     * Full constructor
     * 
     * @param email
     * @param firstName
     * @param lastName
     * @param name
     * @param phone
     */
    public BaseUser(String email, String firstName, String lastName, String name, String phone) {
       this.email = email;
       this.firstName = firstName;
       this.lastName = lastName;
       this.name = name;
       this.phone = phone;
    } 
    
    /**
     * Getter for property <code>id</code>.
     * @return Value of <code>id</code>.
     */
    @Id 
    @Column(name = "user_acc_id")
    @GeneratedValue(generator="smartBPM",strategy=GenerationType.TABLE)
    @TableGenerator(name="smartBPM",initialValue=1000,allocationSize=1)    
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
     * Getter for property <code>firstName</code>.
     * @return Value of <code>firstName</code>.
     */
    @Column(name = "first_name",length=50)
    public String getFirstName() {
        return firstName;
    }
    /**
     * Setter for property <code>firstName</code>.
     * @param firstName new value of <code>firstName</code>.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Getter for property <code>lastName</code>.
     * @return Value of <code>lastName</code>.
     */
    @Column(name = "last_name",length=50)
    public String getLastName() {
        return lastName;
    }
    /**
     * Setter for property <code>lastName</code>.
     * @param lastName new value of <code>lastName</code>.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Getter for property <code>phone</code>.
     * @return Value of <code>phone</code>.
     */
    @Column(length=25)
    public String getPhone() {
        return phone;
    }
    /**
     * Setter for property <code>phone</code>.
     * @param phone new value of <code>phone</code>.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Getter for property <code>email</code>.
     * @return Value of <code>email</code>.
     */
    @Column(length=100)
    public String getEmail() {
        return email;
    }
    /**
     * Setter for property <code>email</code>.
     * @param email new value of <code>email</code>.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for property <code>password</code>.
     * @return Value of <code>password</code>.
     */
    @Column(length=25)
    public String getPassword() {
        return password;
    }

    /**
     * Setter for property <code>password</code>.
     * @param password new value of <code>password</code>.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}