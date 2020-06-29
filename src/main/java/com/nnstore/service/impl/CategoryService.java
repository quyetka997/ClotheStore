package com.nnstore.service.impl;

import com.nnstore.converter.CategoryConverter;
import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.CategoryDTO;
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

    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        if (categories != null) {
            for (Category category : categories) {
                categoryDTOs.add(categoryConverter.toDTO(category));
            }
        }
        return categoryDTOs;
    }

    @Override
    public CategoryDTO findOne(Long id) {
        Category category = categoryRepository.getOne(id);
        if (category == null) {
            return null;
        }
        return categoryConverter.toDTO(category);
    }

    @Override
    public Category findCategory(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(categoryConverter.toEntity(categoryDTO, new Category()));
        return categoryConverter.toDTO(category);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findOne(categoryDTO.getId());
        return categoryConverter.toDTO(categoryRepository.save(categoryConverter.toEntity(categoryDTO,category)));
    }

    @Override
    public List<ProductDTO> findProductByCategoryId(Long id) {
        List<Product> products = categoryRepository.findOne(id).getProducts();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public int getCountProduct(Long id) {
        return categoryRepository.findOne(id).getProducts().size();
    }
}
