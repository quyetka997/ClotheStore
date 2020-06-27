package com.nnstore.service.impl;

import com.nnstore.entity.Category;
import com.nnstore.entity.Product;
import com.nnstore.repository.CategoryRepository;
import com.nnstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> findProductByCategoryId(Long id) {
        return categoryRepository.findOne(id).getProducts();
    }

    @Override
    public int getCountProduct(Long id) {
        return categoryRepository.findOne(id).getProducts().size();
    }
}
