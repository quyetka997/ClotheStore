package com.nnstore.service;

import com.nnstore.dto.UserDTO;
import com.nnstore.entity.User;

import java.util.List;

public interface IUserService {

    List<UserDTO> findAll();

    UserDTO findOneById(Long id);

    UserDTO findOneByUserNameAndPassWord(String username, String password);

    UserDTO findOneByUserName(String username);

    UserDTO save(UserDTO user);

    void delete(Long id);
}
