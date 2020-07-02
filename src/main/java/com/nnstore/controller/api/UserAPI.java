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

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.findOneByUserNameAndPassWord(userDTO.getUserName(), userDTO.getPassWord());
        if(user == null) {
            throw new NotFoundException("Username not exists ");
        }
        userSession.addUser(user);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        if(userService.findOneByUserNameAndPassWord(userDTO.getUserName(), userDTO.getPassWord()) != null) {
            throw new DuplicateRecordException("Username already exists ");
        }
        UserDTO user = userService.save(userDTO);
        userSession.addUser(user);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @GetMapping("/logout")
    ResponseEntity<?> logout(@RequestBody UserDTO userDTO) {
        if(userService.findOneByUserNameAndPassWord(userDTO.getUserName(), userDTO.getPassWord()) == null) {
            throw new NotFoundException("Username not exists ");
        }
        if(userSession.isValid()) {
            userSession.removeUser();
        }
        return  ResponseEntity.ok("true");
    }

    @GetMapping("/user/all")
    ResponseEntity<?> getUsers() {
        return  ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/user/{id}")
    ResponseEntity<?> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.findOneById(id);
        if(userDTO != null) {
            userSession.addUser(userDTO);
        }
        return  ResponseEntity.ok(userDTO);
    }

    @PostMapping("/adduser")
    ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        if(userService.findOneByUserNameAndPassWord(userDTO.getUserName(), userDTO.getPassWord()) != null) {
            throw new DuplicateRecordException("Username already exists ");
        }
        UserDTO user = userService.save(userDTO);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @PostMapping("/user")
    ResponseEntity<?> getUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.findOneByUserNameAndPassWord(userDTO.getUserName(), userDTO.getPassWord());
        if(user == null) {
            throw new DuplicateRecordException("Username not exists ");
        }
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
