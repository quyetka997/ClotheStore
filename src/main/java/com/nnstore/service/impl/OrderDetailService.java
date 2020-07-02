package com.nnstore.service.impl;

import com.nnstore.converter.OrderDetailConverter;
import com.nnstore.dto.OrderDetailDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.OrderDetail;
import com.nnstore.entity.User;
import com.nnstore.repository.OrderDetailRepository;
import com.nnstore.service.IOrderDetailService;
import com.nnstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    UserService userService;

    @Autowired
    OrderDetailConverter orderDetailConverter;

    @Autowired
    IOrderService orderService;

    @Override
    public List<ProductDTO> findAllByOrderId(Long id) {
        return orderService.findAllProductByOrderId(id);
    }

    @Override
    public OrderDetailDTO insert(OrderDetailDTO orderDetailDTO) {
        orderDetailRepository.save(orderDetailConverter.toEntity(orderDetailDTO, new OrderDetail()));
        return orderDetailDTO;
    }

    @Override
    public OrderDetailDTO update(OrderDetailDTO orderDetailDTO) {
        //Check product exist to add qua
        OrderDetail orderDetail = orderDetailRepository.findOne(orderDetailDTO.getId());
        if(orderDetail == null) {
            return null;
        }
        orderDetailRepository.save(orderDetailConverter.toEntity(orderDetailDTO,orderDetail));
        return orderDetailDTO;
    }

    @Override
    public void delete(Long id) {
        orderDetailRepository.delete(id);
    }
}
