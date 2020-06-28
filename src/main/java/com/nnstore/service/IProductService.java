package com.nnstore.service;

import com.nnstore.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();

    ProductDTO findOneById(Long id);

    ProductDTO save(ProductDTO product);

    void delete(Long id);

    Long getFavoriteCount(Long id);

    Long getViewCount(Long id);

    Long getRemindCount(Long id);

    Long getCount();
}
