package com.nnstore.repository;

import com.nnstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<Order,Long> {
}
