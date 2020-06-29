package com.nnstore.service;

import com.nnstore.entity.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    Role findOneById(Long id);

    Role save(Role role);

    void delete(Long id);

}
