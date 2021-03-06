package com.nnstore.service;

import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();

    ProductDTO findOneById(Long id);

    ProductDTO insert(ProductDTO product);

    ProductDTO save(ProductDTO product);

    List<ProductDTO> findAllByNameLike(String like);

    List<ProductDTO> findAllByCategoryId(Long id);

    List<Product> findAllByOrderDetailId(Long id);

    List<ProductDTO> findAllByCategoryIdAndNameLike(Long id, String name);

    void delete(Long id);

    Long getFavoriteCount(Long id);

    Long getViewCount(Long id);

    Long getRemindCount(Long id);

    Long getCount();

    List<ProductDTO> getFavoriteProducts(Long id);

    List<ProductDTO> getViewProducts(Long id);

    List<ProductDTO> getRemindProducts(Long id);

    boolean addRemindProductToUser(long productId,long userId);

    boolean addFavoriteProductToUser(long productId,long userId);

    boolean addViewedProductToUser(long productId,long userId);
}
