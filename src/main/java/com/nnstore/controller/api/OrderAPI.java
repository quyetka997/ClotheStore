package com.nnstore.controller.api;


import com.nnstore.dto.OrderDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.exception.NotFoundException;
import com.nnstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderAPI {

    @Autowired
    IOrderService orderService;

    @GetMapping("/order")
    ResponseEntity<?> getOrders() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.findAll());
    }

    @GetMapping("/order/{id}")
    ResponseEntity<?> getOrder(@PathVariable Long id) {
        OrderDTO orderDTO = orderService.findOneById(id);
        if(orderDTO == null) {
            throw new NotFoundException("Not Found Order");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDTO);
    }

    @GetMapping("/order/product/{id}")
    ResponseEntity<?> getProductFollowOrderId(@PathVariable Long id) {
        if(orderService.findOneById(id) == null) {
            throw new NotFoundException("Not Found Order");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.findAllProductByOrderId(id));
    }

    @PutMapping("/order")
    ResponseEntity<?> updateOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO order = orderService.findOneById(orderDTO.getId());
        if(order == null) {
            throw new NotFoundException("Not Found Order");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.save(orderDTO));
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        OrderDTO orderDTO = orderService.findOneById(id);
        if(orderDTO == null) {
            throw new NotFoundException("Not Found Order");
        }
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
    }

}
