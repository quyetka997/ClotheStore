package com.nnstore.service.impl;

import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Category;
import com.nnstore.entity.Product;
import com.nnstore.repository.CategoryRepository;
import com.nnstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductConverter productConverter;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<ProductDTO> findProductByCategoryId(Long id) {
        List<Product> products = categoryRepository.findOne(id).getProducts();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product:products) {
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public int getCountProduct(Long id) {
        return categoryRepository.findOne(id).getProducts().size();
    }
}
