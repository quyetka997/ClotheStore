package com.nnstore.converter;

import com.nnstore.dto.CategoryDTO;
import com.nnstore.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return  categoryDTO;
    }

    public Category toEntity(CategoryDTO categoryDTO, Category result) {
        result.setId(categoryDTO.getId());
        result.setName(categoryDTO.getName());
        return  result;
    }
}
