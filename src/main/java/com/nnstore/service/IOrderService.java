package com.nnstore.service;

import com.nnstore.entity.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();

    Order findOneById(Long id);

    Order save(Order order);

    Long revenueMonthAndYear(int month, int year);
}
