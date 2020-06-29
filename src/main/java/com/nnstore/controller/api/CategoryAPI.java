package com.nnstore.controller.api;

import com.nnstore.dto.CategoryDTO;
import com.nnstore.entity.Role;
import com.nnstore.exception.NotFoundException;
import com.nnstore.service.ICategoryService;
import com.nnstore.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryAPI {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/category")
    ResponseEntity<?> getRoles() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.findAll());
    }

    @GetMapping("/category/{id}")
    ResponseEntity<?> getRole(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.findOne(id);
        if(categoryDTO == null) {
            throw new NotFoundException("Role not found");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryDTO);
    }

    @PostMapping("/category")
    ResponseEntity<?> insertCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.insert(categoryDTO));
    }

    @PutMapping("/category")
    ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = categoryService.findOne(categoryDTO.getId());
        if(category == null) {
            throw new NotFoundException("Not Found Category");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.update(categoryDTO));
    }
}
