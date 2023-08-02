package com.brevissimus.smartbpm.common.dto;

import java.io.Serializable;

/**
 *<p>UserDTO</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.24.</p>
 */

public class UserDTO implements Serializable{
    
    private static final long serialVersionUID = 2603661065820891244L;

    private Long id;
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    
    /**
     * Default constructor
     */
    public UserDTO() {
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
    public UserDTO(String email, String firstName, String lastName, String name, String phone) {
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserDTO[id=" + id + ",")
          .append("name='" + name + "',")
          .append("firstName='" + firstName + "',")
          .append("lastName='" + lastName + "',")
          .append("email='" + email + "',")
          .append("phone='" + phone + "']");
        return sb.toString();
    }    
}

