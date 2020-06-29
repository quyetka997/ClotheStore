package com.nnstore.controller.api;

import com.nnstore.entity.Role;
import com.nnstore.exception.NotFoundException;
import com.nnstore.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleAPI {

    @Autowired
    IRoleService roleService;

    @GetMapping("/role")
    ResponseEntity<?> getRoles() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roleService.findAll());
    }

    @GetMapping("/role/{id}")
    ResponseEntity<?> getRole(@PathVariable Long id) {
        Role role = roleService.findOneById(id);
        if(role == null) {
            throw new NotFoundException("Role not found");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(role);
    }

    @PostMapping("/role")
    ResponseEntity<?> addRoles(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roleService.save(role));
    }


}
