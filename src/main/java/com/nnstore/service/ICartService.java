package com.nnstore.service;

import com.nnstore.dto.CartDetailDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Cart;
import com.nnstore.entity.Product;

import java.util.List;

public interface ICartService {

    List<CartDetailDTO> getProducts(Long id);

    List<CartDetailDTO> insertProduct(CartDetailDTO cartDetailDTO, Long id);

    List<CartDetailDTO> updateProduct(CartDetailDTO cartDetailDTO, Long id);

    void delete(Long id);

}
