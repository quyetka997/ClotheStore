package com.nnstore.session;


import com.nnstore.dto.UserDTO;
import com.nnstore.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope // name = userSession
@Component
public class UserSession {

    public UserDTO user;

    public UserDTO getUser(){
        return user;
    }

    public void addUser(UserDTO userDTO){
        user = userDTO;
    }

    public void  updateUser(UserDTO userDTO) {
        user.setUserName(userDTO.getUserName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassWord(userDTO.getPassWord());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
    }

    public void removeUser() {
        user = null;
    }

    public boolean isValid() {
        return  user != null;
    }

}
