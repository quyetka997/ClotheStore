package com.nnstore.converter;

import com.nnstore.dto.OrderDetailDTO;
import com.nnstore.entity.Order;
import com.nnstore.entity.OrderDetail;
import com.nnstore.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter {

    public OrderDetailDTO toDTO(OrderDetail orderDetail) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setAmount(orderDetail.getAmount());
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setOrderId(orderDetail.getOrder().getId());
        orderDetailDTO.setProductId(orderDetail.getProduct().getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        return  orderDetailDTO;
    }

    public OrderDetail toEntity(OrderDetailDTO orderDetailDTO, OrderDetail result) {
        result.setId(orderDetailDTO.getId());
        Order order = new Order(orderDetailDTO.getOrderId());
        result.setOrder(order);
        Product product = new Product(orderDetailDTO.getProductId());
        result.setProduct(product);
        result.setQuantity(orderDetailDTO.getQuantity());
        return result;
    }
}
