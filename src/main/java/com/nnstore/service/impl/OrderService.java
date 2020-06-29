package com.nnstore.service.impl;

import com.nnstore.converter.OrderConverter;
import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.OrderDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Order;
import com.nnstore.entity.OrderDetail;
import com.nnstore.entity.Product;
import com.nnstore.repository.OrderRepository;
import com.nnstore.repository.ProductRepository;
import com.nnstore.service.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderConverter orderConverter;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        if(orders != null) {
            for (Order order: orders) {
                orderDTOs.add(orderConverter.toDTO(order));
            }
        }
        return orderDTOs;
    }

    @Override
    public OrderDTO findOneById(Long id) {
        Order order = orderRepository.findOne(id);
        if(order == null) {
            return null;
        }
        return orderConverter.toDTO(order);
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderRepository.findOne(orderDTO.getId());
        if(order == null) {
            return null;
        }
        orderRepository.save(orderConverter.toEntity(orderDTO, order));
        return orderDTO;
    }

    @Override
    public Long revenueMonthAndYear(int month, int year) {
        return null;
    }

    @Override
    public List<ProductDTO> findAllProductByOrderId(Long id) {
        Order orders = orderRepository.findOne(id);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(OrderDetail orderDetail: orders.getOrderDetails()) {
            ProductDTO newProductDTO = productConverter.toDTO(orderDetail.getProduct());
            newProductDTO.setQuantity(orderDetail.getQuantity());
            productDTOs.add(newProductDTO);
        }
        return productDTOs;
    }

    @Override
    public void delete(Long id) {
        //delete OrderDetail
        //delete Order
    }
}
