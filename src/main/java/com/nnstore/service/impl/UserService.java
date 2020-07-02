package com.nnstore.service.impl;

import com.nnstore.converter.UserConverter;
import com.nnstore.dto.UserDTO;
import com.nnstore.entity.User;
import com.nnstore.repository.UserRepository;
import com.nnstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user: users) {
            userDTOs.add(userConverter.toDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserDTO findOneById(Long id) {
        User user = userRepository.findOne(id);
        if(user == null) {
            return null;
        }
        return userConverter.toDTO(user);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserDTO findOneByUserNameAndPassWord(String username, String password) {
        //List<User> users = userRepository.findFirstByUserNameAndPassWord(username, password);
        User user = userRepository.findFirstByUserNameAndPassWord(username, password);
        if(user == null) {
            return null;
        }
        UserDTO userDTO = userConverter.toDTO(user);
        return userDTO;
    }

    @Override
    public UserDTO findOneByUserName(String username) {
        User user = userRepository.findFirstByUserName(username);
        if(user == null) {
            return null;
        }
        UserDTO userDTO = userConverter.toDTO(user);
        return userDTO;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User result = userConverter.toEntity(userDTO, new User());
        return userConverter.toDTO(userRepository.save(result));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findOne(userDTO.getId());
        User result = userConverter.toEntity(userDTO, user);
        return userConverter.toDTO(userRepository.save(result));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
