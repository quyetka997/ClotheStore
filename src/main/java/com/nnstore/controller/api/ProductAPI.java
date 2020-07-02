package com.nnstore.controller.api;

import com.nnstore.dto.ProductDTO;
import com.nnstore.exception.NotFoundException;
import com.nnstore.service.ICategoryService;
import com.nnstore.service.IProductService;
import com.nnstore.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAPI {

    @Autowired
    IProductService productService;

    @Autowired
    UserSession userSession;
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

    @GetMapping("/product/view")
    ResponseEntity<?> getViewedProduct() {
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getViewProducts(userSession.getUser().getId()));
        }
        //TODO: check again
        return ResponseEntity.ok("User not login");
    }

    @PostMapping("/product/view/{id}")
    ResponseEntity<?> addViewedProduct(@PathVariable Long id) {
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.addViewedProductToUser(id, userSession.getUser().getId()));
        }
        return ResponseEntity.ok("User not login");
    }

    @GetMapping("/product/favorite")
    ResponseEntity<?> getFavoriteProduct() {
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getFavoriteCount(userSession.getUser().getId()));
        }
        return ResponseEntity.ok("User not login");
    }

    @PostMapping("/product/favorite/{id}")
    ResponseEntity<?> addFavoriteProduct(@PathVariable Long id) {
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.addFavoriteProductToUser(id, userSession.getUser().getId()));
        }
        return ResponseEntity.ok("User not login");
    }

    @GetMapping("/product/remind")
    ResponseEntity<?> getRemindedProduct() {
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getRemindProducts(userSession.getUser().getId()));
        }
        return ResponseEntity.ok("User not login");
    }

    @PostMapping("/product/remind/{id}")
    ResponseEntity<?> addRemindedProduct(@PathVariable Long id) {
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.addRemindProductToUser(id, userSession.getUser().getId()));
        }
        return ResponseEntity.ok("User not login");
    }


}
