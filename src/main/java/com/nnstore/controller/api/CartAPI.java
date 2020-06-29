package com.nnstore.controller.api;

import com.nnstore.dto.ProductDTO;
import com.nnstore.service.IProductService;
import com.nnstore.session.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartAPI {



//    @Autowired
//    IProductService productService;
//
//    @GetMapping("/cart")
//    ResponseEntity<?> getCart(){
//        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
//    }
//
//    @PostMapping("/cart/{id}")
//    ResponseEntity<?> addProductIntoCart(@PathVariable Long id){
//        cartSession.add(id);
//        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
//    }
//
//    @PutMapping("/cart")
//    ResponseEntity<?> updateCartProduct(@RequestParam Long id, @RequestParam Integer quantity){
//        cartSession.update(id, quantity);
//        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
//    }
//
//    @DeleteMapping("/cart/delete")
//    ResponseEntity<?> deleteCart(@RequestParam Long id, @RequestParam Integer quantity){
//        cartSession.clear();
//        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
//    }
//
//    @DeleteMapping("/cart/{id}")
//    ResponseEntity<?> deleteProductCart(@PathVariable Long id){
//        cartSession.remove(id);
//        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
//    }

}
