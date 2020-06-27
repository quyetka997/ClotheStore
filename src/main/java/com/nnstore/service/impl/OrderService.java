package com.nnstore.service.impl;

import com.nnstore.entity.Order;
import com.nnstore.repository.OrderRepository;
import com.nnstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOneById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Long revenueMonthAndYear(int month, int year) {
        return null;
    }
}
