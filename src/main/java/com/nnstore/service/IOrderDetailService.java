package com.nnstore.service;

import com.nnstore.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    List<OrderDetail> findAll();

    OrderDetail save(OrderDetail orderDetail);

    void delelte(Long id);
}
