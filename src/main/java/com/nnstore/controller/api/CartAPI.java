package com.nnstore.controller.api;

import com.nnstore.dto.CartDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.exception.NotFoundException;
import com.nnstore.service.ICartService;
import com.nnstore.service.IProductService;
import com.nnstore.session.CartSession;
import com.nnstore.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartAPI {

    @Autowired
    IProductService productService;

    @Autowired
    ICartService cartService;

    @Autowired
    CartSession cartSession;

    @Autowired
    UserSession userSession;

    @GetMapping("/cart")
    ResponseEntity<?> getCart(){
        if(userSession.isValid()) {
            CartDTO cartDTO = cartService.getCart(userSession.getUser().getId());
            if(cartDTO == null) {
                throw new NotFoundException("You don't have Cart");
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartDTO);
        } else {
            // get Product from Session

        }
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
    }

    @GetMapping("/cart/product")
    ResponseEntity<?> getProductFromCart(){
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.getProducts(userSession.getUser().getId()));
        } else {
            // add to Session
            //cartSession.add(id);
        }

        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
    }

    @PostMapping("/cart/product")
    ResponseEntity<?> addProductIntoCart(@RequestBody ProductDTO productDTO){
        if(userSession.isValid()) {
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.insertProductToCart(productDTO,userSession.getUser().getId()));
        } else {
            // add to Session
            //cartSession.add(id);
        }

        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
    }

    @PutMapping("/cart/product")
    ResponseEntity<?> updateCartProduct(@RequestBody ProductDTO productDTO){
        if(userSession.isValid()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.updateProduct(productDTO, userSession.getUser().getId()));
        } else {
            // add to Session
            //cartSession.add();
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cart session");
    }

    @DeleteMapping("/cart/product/{id}")
    ResponseEntity<?> deleteProductInCart(@PathVariable Long id){
        if(userSession.isValid()) {
            cartService.deleteProduct(id, userSession.getUser().getId());
        } else {
            // add to Session
            //cartSession.add();
        }
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
    }

    @DeleteMapping("/cart/{id}")
    ResponseEntity<?> deleteProductCart(@PathVariable Long id){
        if(userSession.isValid()) {
            cartService.deleteCart(userSession.getUser().getId());
        } else {
            // add to Session
            //cartSession.add();
        }
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartSession.getProducts());
    }

}
