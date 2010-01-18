/**
 * 
 */
package com.brevissimus.smartbpm.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brevissimus.smartbpm.model.User;
import com.brevissimus.smartbpm.common.SmartBpmException;
import com.brevissimus.smartbpm.common.BaseService;
import com.brevissimus.smartbpm.common.dto.UserDTO;
import com.brevissimus.smartbpm.dao.UserDAO;
import com.brevissimus.smartbpm.dto.assembly.UserFactory;

/**
 *<p>UserService</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.11.</p>
 */
@Service
public class UserService extends BaseService {
    private static final Log logger = LogFactory.getLog(UserService.class);

    // injected by spring
    private UserDAO userDAO;

    /**
     * Getter for property <code>userDAO</code>.
     * @return Value of <code>userDAO</code>.
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Setter for property <code>userDAO</code>.
     * @param userDAO new value of <code>userDAO</code>.
     */
    @Autowired   
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    
    /**
     * @param userId
     * @param processId
     * @return StateDTO
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public List<UserDTO> findAll() throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("SmartBPM getting all the Users");
            Collection<User> users = userDAO.getAllUser(session);
            ArrayList<UserDTO> userDTOs = new ArrayList<UserDTO>(); 
            for (User user : users) {
                userDTOs.add(UserFactory.createUserDTO(user));
            }          
            return userDTOs;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
            throw new SmartBpmException(ex,"rollback is needed");

        }
    }
    
    
    /**
     * @param name 
     * @return List<UserDTO>
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public List<UserDTO> findByFirstnameAndLastname(String name) throws SmartBpmException { 
        Session session = getCurrentSession();
        try {
            logger.debug("SmartBPM findByFirstnameAndLastname");
            Collection<User> users = userDAO.getByFirstnameAndLastname(name, session);
            ArrayList<UserDTO> userDTOs = new ArrayList<UserDTO>(); 
            if (users != null) {
                for (User user : users) {
                    userDTOs.add(UserFactory.createUserDTO(user));
                }
            }
            return userDTOs;
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
            throw new SmartBpmException(ex,"rollback is needed");
    
        }
    }
    
    /**
     * 
     * @param username 
     * @param password 
     * @return Is authentication is successful?
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public boolean authenticate(String username,String password) throws SmartBpmException { 
        Session session = getCurrentSession();
        try {
            logger.debug("starting");
            return userDAO.authenticate(username, password, session);
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
            throw new SmartBpmException(ex,"rollback is needed");
        }
    }
    
    
    /**
     * @param userDTO 
     * @throws SmartBpmException 
     */
    @Transactional
    public void save(UserDTO userDTO) throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("SmartBPM save a user");
            if (userDTO != null) {
                User user = UserFactory.createUser(userDTO);
                userDAO.attachDirty(user, session);
            }
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
            throw new SmartBpmException(ex,"rollback is needed");

        }
    }
    
    /**
     * @param userId 
     * @param userDTO 
     * @return UserDTO
     * @throws SmartBpmException 
     */
    @Transactional(readOnly=true)
    public UserDTO get(Long userId) throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("SmartBPM getting the User"); 
            User user=userDAO.getById(userId, session);
            return UserFactory.createUserDTO(user);
        } catch (HibernateException ex) {
            logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
            throw new SmartBpmException(ex,"rollback is needed");

        }
    }
    
    /**
     * @param userId 
     * @param userDTO 
     * @throws SmartBpmException 
     */
    @Transactional
    public void removeById(Long userId) throws SmartBpmException {
        Session session = getCurrentSession();
        try {
            logger.debug("SmartBPM remove user");
            userDAO.removeById(userId, session);
        } catch (Exception ex) {
            //logger.error("Failed");
            //programmatic packaged with exception can be throw from here 
           // throw new SmartBpmException(ex,"rollback is needed");
        }
        
    }
}

