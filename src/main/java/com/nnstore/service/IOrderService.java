package com.nnstore.service;

import com.nnstore.dto.OrderDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderService {

    List<OrderDTO> findAll();

    OrderDTO findOneById(Long id);

    OrderDTO save(OrderDTO order);

    Long revenueMonthAndYear(int month, int year);

    void delete(Long id);

    List<ProductDTO> findAllProductByOrderId(Long id);
}
