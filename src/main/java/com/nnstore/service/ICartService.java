package com.nnstore.service;

import com.nnstore.dto.CartDTO;
import com.nnstore.dto.CartDetailDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Cart;
import com.nnstore.entity.CartDetail;
import com.nnstore.entity.Product;

import java.util.List;

public interface ICartService {

    CartDTO getCart(Long idCart);

    List<ProductDTO> getProducts(Long idCart);

    ProductDTO insertProductToCart(ProductDTO productDTO, Long idCart);

    ProductDTO updateProduct(ProductDTO productDTO, Long idCart);

    void deleteProduct(Long idProduct, Long idCart);

    void deleteCart(Long id);

}
