package com.brevissimus.smartbpm.dto.assembly;

import com.brevissimus.smartbpm.model.User;
import com.brevissimus.smartbpm.common.dto.UserDTO;

/**
 *<p>UserFactory</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.06.24.</p>
 */


public class UserFactory {
    // Later we can do it by BeanUtils of common
    
    /**
     * creating DTO. 
     * @param user 
     * @return userDTO
     */
    public static UserDTO createUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }
    /**
     * creating Model object
     * @param userDTO 
     * @return user
     */
    public static User createUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        return user;
    }
}

