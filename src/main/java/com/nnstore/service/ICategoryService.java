package com.nnstore.service;

import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Category;
import com.nnstore.entity.Product;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findOne(Long id);

    List<ProductDTO> findProductByCategoryId(Long id);

    int getCountProduct(Long id);
}
