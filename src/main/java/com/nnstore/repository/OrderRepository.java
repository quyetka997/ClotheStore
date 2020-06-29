package com.nnstore.repository;

import com.nnstore.entity.Order;
import com.nnstore.entity.OrderDetail;
import com.nnstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "Select SUM(Orders.amount) from Orders" +
                    "WHERE YEAR (Orders.CreatedDate) = ?1 AND MONTH(Orders.CreatedDate) = ?2",nativeQuery = true)
    Double revenueMonthAndYear(int month,int year);

    @Query(value = "Select MONTH(Orders.CreatedDate), SUM(Orders.amount) from Orders" +
            "WHERE YEAR (Orders.CreatedDate) = ?1" +
            "GROUP BY MONTH(Orders.CreatedDate)",nativeQuery = true)
    List<Object> revenueYear(int year);
    
}
