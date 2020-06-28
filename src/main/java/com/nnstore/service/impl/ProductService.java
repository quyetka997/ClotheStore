package com.nnstore.service.impl;

import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Product;
import com.nnstore.repository.ProductRepository;
import com.nnstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductConverter productConverter;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOs = new ArrayList<>();

        List<Product> products = new ArrayList<>();

        for (Product product: products) {
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public ProductDTO findOneById(Long id) {
        return productConverter.toDTO(productRepository.findOne(id));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.getOne(productDTO.getId());

        Product result = productConverter.toEntity(productDTO, product);
        return productConverter.toDTO(productRepository.save(result));
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Long getFavoriteCount(Long id) {
        //return productRepository.getFavoriteCount(id);
        return id;
    }

    @Override
    public Long getViewCount(Long id) {
        //return productRepository.getViewCount(id);
        return id;
    }

    @Override
    public Long getRemindCount(Long id) {
        //return productRepository.getRemindCount(id);
        return id;
    }

    @Override
    public Long getCount() {
        return productRepository.count();
    }
}
