package com.nnstore.converter;

import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.CartDetail;
import com.nnstore.entity.Category;
import com.nnstore.entity.Product;
import com.nnstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    @Autowired
    ICategoryService categoryService;

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setThumnail(product.getThumnail());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setSale(product.getSale());
        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO, Product result) {
        result.setId(productDTO.getId());
        result.setDescription(productDTO.getDescription());
        result.setName(productDTO.getName());
        result.setPrice(productDTO.getPrice());
        result.setThumnail(productDTO.getThumnail());
        result.setQuantity(productDTO.getQuantity());
        result.setSale(productDTO.getSale());
        if(result.getCategory() == null
                || productDTO.getCategoryId() != result.getCategory().getId()) {
            //Category category = categoryService.findCategory(productDTO.getCategoryId());
            Category category = new Category();
            category.setId(productDTO.getCategoryId());
            result.setCategory(category);
        }
        return result;
    }


}
