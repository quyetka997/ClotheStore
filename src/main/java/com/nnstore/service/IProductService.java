package com.nnstore.service;

import com.nnstore.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findOneById(Long id);

    Product save(Product product);

    void delete(Long id);

    int getFavoriteCount(Long id);

    int getViewCount(Long id);

    int getRemindCount(Long id);

    Long getCoutn();
}
