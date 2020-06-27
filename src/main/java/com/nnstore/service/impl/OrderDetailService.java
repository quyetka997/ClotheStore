package com.nnstore.service.impl;

import com.nnstore.entity.OrderDetail;
import com.nnstore.repository.OrderDetailRepository;
import com.nnstore.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    EntityManager em;

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delelte(Long id) {
        orderDetailRepository.delete(id);
    }
}
