package com.nnstore.repository;

import com.nnstore.entity.Category;
import com.nnstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
