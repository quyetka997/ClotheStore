package com.nnstore.converter;

import com.nnstore.dto.CartDTO;
import com.nnstore.entity.Cart;
import com.nnstore.entity.CartDetail;
import com.nnstore.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public CartDTO toDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setAmount(cart.getAmount());
        cartDTO.setId(cart.getId());
        int quantity = 0;
        for (CartDetail cartDetail: cart.getProducts()) {
            quantity += cartDetail.getQuantity();
        }
        cartDTO.setQuantity(quantity);
        cartDTO.setSale(cart.getSale());
        return cartDTO;
    }

}
