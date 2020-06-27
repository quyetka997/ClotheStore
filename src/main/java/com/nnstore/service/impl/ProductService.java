package com.nnstore.service.impl;

import com.nnstore.entity.Product;
import com.nnstore.repository.ProductRepository;
import com.nnstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOneById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public int getFavoriteCount(Long id) {
        return productRepository.getOne(id).getFavoriteUsers().size();
    }

    @Override
    public int getViewCount(Long id) {
        return productRepository.getOne(id).getViewUsers().size();
    }

    @Override
    public int getRemindCount(Long id) {
        return productRepository.getOne(id).getRemindUsers().size();
    }

    @Override
    public Long getCoutn() {
        return productRepository.count();
    }
}
