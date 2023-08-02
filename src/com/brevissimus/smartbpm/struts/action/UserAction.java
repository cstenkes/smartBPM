package com.brevissimus.smartbpm.struts.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brevissimus.smartbpm.common.SmartBpmException;
import com.brevissimus.smartbpm.common.dto.UserDTO;
import com.brevissimus.smartbpm.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;


/**
 *<p>UserAction</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.26.</p>
 */

public class UserAction implements Preparable {
    private static final Logger logger = Logger.getLogger(UserAction.class);
    
    private UserService userService;
    private UserDTO selectedUser = new UserDTO();
    private List<UserDTO> users;
    private UserDTO user;
    private Long id;
    private String searchText;
    private String mode;
    
    public UserAction() {
        try {
           ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
           userService = (UserService)context.getBean("userService");
        } catch (Exception e) {
            logger.fatal("xxxxxxxxxxxxxxxxxxxxxxxx Cannot initialize Spring Application Context: "+e, e);
        }
    }

    /**
     * Struts2 action
     * @return
     */
    public String edit() {
        try {
            this.selectedUser = userService.get(id);
            this.users = userService.findAll();
        } catch (SmartBpmException e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }

    
    /**
     * Struts2 action
     * @return
     */
    public String search() {
        try {
            logger.info("searchText:"+searchText);
            if (id != null) {
                this.selectedUser = userService.get(id);
            }
            this.users = userService.findByFirstnameAndLastname(searchText);
        } catch (SmartBpmException e) {
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }


    /**
     * Struts2 action
     * @return
     */
    public String add() {
        this.selectedUser = null;
        return execute();
    }
    
    /**
     * Struts2 action
     * @return
     */
    public String execute() {
        try {
            
            this.users = userService.findAll();
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Action.SUCCESS;
    }
    
    
    /**
     * Struts2 action
     * @return
     */
    public String save() {
        try {
            if (selectedUser!=null){
                logger.info("selectedUser:"+selectedUser);
                userService.save(selectedUser);
            }
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.user = new UserDTO();
        return execute();
    }

    /**
     * Struts2 action
     * @return
     */
    public String authenticate() {
        try {
            if (selectedUser != null){
                logger.info("selectedUser:"+selectedUser);
                boolean successful = userService.authenticate(selectedUser.getName(), selectedUser.getPassword());
                if (!successful){
                    return Action.ERROR; 
                }
                selectedUser = null;
            }
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return execute();
    }

    
    
    /**
     * Struts2 action
     * @return
     */
    public String remove() {
        try {
            userService.removeById(id);
        } catch (SmartBpmException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        return execute();
    }

    /**
     * getter for Persons
     * @return 
     */
    public List<UserDTO> getUsers() {
        return users;
    }

    /**
     * getter for id
     * @return
     */
    public Long getId() {
        return id;
    }
    
    /**
     * setter for id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void prepare() throws Exception {
        if (id != null){
            user = userService.get(id);
        }
    }

    
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    
    /**
     * Setter for property <code>selectedUser</code>.
     * @param selectedUser new value of <code>selectedUser</code>.
     */
    public void setSelectedUser(UserDTO selectedUser) {
        this.selectedUser = selectedUser;
    }

    
    /**
     * Getter for property <code>selectedUser</code>.
     * @return Value of <code>selectedUser</code>.
     */
    public UserDTO getSelectedUser() {
        return selectedUser;
    }

    
    /**
     * Setter for property <code>text</code>.
     * @param text new value of <code>text</code>.
     */
    public void setSearchText(String text) {
        this.searchText = text;
    }

    
    /**
     * Getter for property <code>text</code>.
     * @return Value of <code>text</code>.
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * Getter for property <code>mode</code>.
     * @return Value of <code>mode</code>.
     */
    public String getMode() {
        return mode;
    }

    /**
     * Setter for property <code>mode</code>.
     * @param mode new value of <code>mode</code>.
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
}