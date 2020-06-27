package com.nnstore.service;

import com.nnstore.entity.Role;

public interface IRoleService {

    Role findOneById(Long id);

    Role save(Role role);

    void delete(Long id);

}
