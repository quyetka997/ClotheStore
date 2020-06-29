package com.nnstore.controller.api;

import com.nnstore.converter.UserConverter;
import com.nnstore.dto.UserDTO;
import com.nnstore.exception.DuplicateRecordException;
import com.nnstore.exception.NotFoundException;
import com.nnstore.service.IUserService;
import com.nnstore.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {

    @Autowired
    IUserService userService;

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserSession userSession;

    @GetMapping("/user")
    ResponseEntity<?> getUsers() {
        return  ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping("/user/{id}")
    ResponseEntity<?> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.findOneById(id);
        if(userDTO != null) {
            userSession.addUser(userDTO);
        }
        return  ResponseEntity.ok(userDTO);
    }

    @PostMapping("/user")
    ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        if(userService.findOneByUserNameAndPassWord(userDTO.getUserName(), userDTO.getPassWord()) != null) {
            throw new DuplicateRecordException("Username already exists ");
        }
        UserDTO user = userService.save(userDTO);
        userSession.addUser(user);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @PutMapping("/user")
    ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        if(userService.findOneByUserName(userDTO.getUserName()) == null) {
            throw new NotFoundException("User not exists ");
        }
        userService.save(userDTO);
        userSession.updateUser(userDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDTO);
    }

    @DeleteMapping("/user")
    ResponseEntity<?> delete(Long id) {
        userService.delete(id);
        userSession.removeUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
    }

}
