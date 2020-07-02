package com.nnstore.repository;

import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Product;
import com.nnstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameLike(String like);

    List<Product> findAllByCategoryId(Long id);

    List<Product> findAllByCategoryIdAndNameLike(Long id, String name);


//    @Query("SELECT COUNT(*) FROM user_product_favorite where productId = ?1 ")
//    Long getFavoriteCount(Long id);
//
//    @Query(value = "SELECT COUNT(*) FROM user_product_view where productId = ?1 ", nativeQuery = true)
//    Long getViewCount(Long id);
//
//    @Query(value = "SELECT COUNT(*) FROM user_product_remind where productId = ?1 ", nativeQuery = true)
//    Long getRemindCount(Long id);
}
