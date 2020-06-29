package com.nnstore.converter;


import com.nnstore.dto.OrderDTO;
import com.nnstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    UserConverter userConverter;

    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setAmount(order.getAmount());
        orderDTO.setCreatedDate(order.getCreatedDate());
        orderDTO.setId(order.getId());
        orderDTO.setSale(order.getSale());
        orderDTO.setUserDTO(userConverter.toDTO(order.getUser()));
        return orderDTO;
    }

    public Order toEntity(OrderDTO orderDTO, Order result) {
        result.setAmount(orderDTO.getAmount());
        result.setCreatedDate(orderDTO.getCreatedDate());
        result.setId(orderDTO.getId());
        result.setSale(orderDTO.getSale());
        return result;
    }

}
