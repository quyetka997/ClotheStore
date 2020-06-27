package com.nnstore.service;

import com.nnstore.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findOneByUserNameAndPassWord(String username, String password);

    User save(User user);

    void delete(Long id);
}
