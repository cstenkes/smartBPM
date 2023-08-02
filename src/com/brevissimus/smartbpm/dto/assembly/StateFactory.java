package com.brevissimus.smartbpm.dto.assembly;

import com.brevissimus.smartbpm.model.State;
import com.brevissimus.smartbpm.common.dto.StateDTO;

/**
 *<p>ProcessTypeFactory</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.07.01.</p>
 */


public class StateFactory {
    
    /**
     * creating DTO. 
     *  
     * @param state
     * @return stateDTO
     */
    public static StateDTO createStateDTO(State state) {
        StateDTO stateDTO = new StateDTO();
        stateDTO.setName(state.getName());
        stateDTO.setDescription(state.getDescription());
        stateDTO.setId(state.getId());
        return stateDTO;
    }

    /**
     * creating model object. 
     *  
     * @param stateDTO
     * @return state
     */
    public static State createState(StateDTO stateDTO) {
        State state = new State();
        state.setName(stateDTO.getName());
        state.setDescription(stateDTO.getDescription());
        state.setId(stateDTO.getId());
        return state;
    }   
}