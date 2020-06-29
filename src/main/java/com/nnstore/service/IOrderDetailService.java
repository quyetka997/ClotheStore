package com.nnstore.service;

import com.nnstore.dto.OrderDetailDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    List<ProductDTO> findAllByOrderId(Long id);

    OrderDetailDTO insert(OrderDetailDTO orderDetail);

    OrderDetailDTO update(OrderDetailDTO orderDetail);

    void delete(Long id);
}
