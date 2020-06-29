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

    @GetMapping("/product")
    ResponseEntity<?> getAllProductFollowCategory(@RequestParam(required = false) Long categoryId, @RequestParam(required = false) String name) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.findAllByCategoryIdAndNameLike(categoryId, name));
    }

    @RequestMapping("/product/{id}")
    ResponseEntity<?> getProductFollowCategory(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.findOneById(id));
    }

    @PostMapping("/product")
    ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.insert(productDTO));
    }

    @RequestMapping(value = {"/product/search"})
    public ResponseEntity<?> search(@RequestParam(name = "keyword", required = false,defaultValue = "") String name){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.findAllByNameLike(name));
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
