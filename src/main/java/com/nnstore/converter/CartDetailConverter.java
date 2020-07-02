package com.nnstore.converter;

import com.nnstore.dto.CartDetailDTO;
import com.nnstore.entity.Cart;
import com.nnstore.entity.CartDetail;
import com.nnstore.entity.Product;

public class CartDetailConverter {

    CartDetailDTO toDTO(CartDetail cartDetail) {
        CartDetailDTO cartDetailDTO = new CartDetailDTO();
        cartDetailDTO.setAmount(cartDetail.getAmount());
        cartDetailDTO.setCartId(cartDetail.getCart().getId());
        cartDetailDTO.setId(cartDetail.getId());
        cartDetailDTO.setProductId(cartDetail.getProduct().getId());
        cartDetailDTO.setQuantity(cartDetail.getQuantity());
        return cartDetailDTO;
    }

    CartDetail toEntity(CartDetailDTO cartDetailDTO, CartDetail result) {
        Cart cart = new Cart();
        cart.setId(cartDetailDTO.getCartId());
        result.setCart(cart);
        result.setId(cartDetailDTO.getId());
        Product product = new Product();
        product.setId(cartDetailDTO.getId());
        result.setProduct(product);
        result.setQuantity(cartDetailDTO.getQuantity());
        return result;
    }
}
