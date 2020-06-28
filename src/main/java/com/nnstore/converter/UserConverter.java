package com.nnstore.converter;

import com.nnstore.dto.UserDTO;
import com.nnstore.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getFullName());
        userDTO.setPassWord(user.getPassWord());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUserName(user.getUserName());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO, User result) {
        result.setId(userDTO.getId());
        result.setEmail(userDTO.getEmail());
        result.setFullName(userDTO.getFullName());
        result.setPassWord(userDTO.getPassWord());
        result.setPhoneNumber(userDTO.getPhoneNumber());
        result.setUserName(userDTO.getUserName());
        return result;
    }
}
