package com.nnstore.service;

import com.nnstore.entity.Category;
import com.nnstore.entity.Product;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    List<Product> findProductByCategoryId(Long id);

    int getCountProduct(Long id);
}
