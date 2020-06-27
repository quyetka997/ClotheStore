package com.nnstore.repository;

import com.nnstore.entity.Order;
import com.nnstore.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
