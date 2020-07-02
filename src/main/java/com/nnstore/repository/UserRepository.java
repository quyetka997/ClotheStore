package com.nnstore.repository;

import com.nnstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUserNameAndPassWord(String username, String password);

    User findFirstByUserName(String username);

}
