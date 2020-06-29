package com.nnstore.controller.api;

import com.nnstore.dto.OrderDetailDTO;
import com.nnstore.service.IOrderDetailService;
import com.nnstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDetailAPI {
    @Autowired
    IOrderDetailService orderDetailService;

    @GetMapping("/orderdetail/{id}")
    ResponseEntity<?> getAllByOrderId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDetailService.findAllByOrderId(id));
    }

    @PostMapping("/orderdetail")
    ResponseEntity<?> insertOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDetailService.insert(orderDetailDTO));
    }

    @PutMapping("/orderdetail")
    ResponseEntity<?> updateOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDetailService.update(orderDetailDTO));
    }

    @DeleteMapping("/orderdetail/{id}")
    ResponseEntity<?> insertOrderDetail(@PathVariable Long id) {
        orderDetailService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
    }
}
