package com.nnstore.controller.api;

import com.nnstore.dto.ProductDTO;
import com.nnstore.service.ICategoryService;
import com.nnstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAPI {

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/product")
    ResponseEntity<?> getAllProduct() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.findAll());
    }

    @GetMapping("/product/{id}")
    ResponseEntity<?> getProductFollowCategory(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.findOneById(id));
    }

    @PostMapping("/product")
    ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.save(productDTO));
    }

//    @GetMapping("/product/view/{id}")
//    ResponseEntity<?> getViewProduct(@PathVariable Long id) {
//
//    }
//
//    @GetMapping("/product/view/{id}")
//    ResponseEntity<?> getRemindProduct() {
//
//    }
//
//    @GetMapping("/product/addview/{id}")
//    ResponseEntity<?> getFavoriteProduct(@PathVariable Long customerID) {
//
//    }
//
//    ResponseEntity<?> addViewProduct() {
//
//    }
//
//    ResponseEntity<?> addRemindProduct() {
//
//    }
//
//    ResponseEntity<?> addFavoriteProduct() {
//
//    }

}
