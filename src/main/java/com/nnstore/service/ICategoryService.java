package com.nnstore.service;

import com.nnstore.dto.CategoryDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Category;
import com.nnstore.entity.Product;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findOne(Long id);

    Category findCategory(Long id);

    CategoryDTO insert(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO);

    List<ProductDTO> findProductByCategoryId(Long id);

    int getCountProduct(Long id);
}
