package com.nnstore.repository;

import com.nnstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassWord(String username, String password);
}
