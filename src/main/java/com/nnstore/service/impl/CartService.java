package com.nnstore.service.impl;

import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.CartDetailDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Cart;
import com.nnstore.entity.CartDetail;
import com.nnstore.entity.Product;
import com.nnstore.repository.CartRepository;
import com.nnstore.service.ICartService;
import com.nnstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductConverter productConverter;


    @Override
    public List<CartDetailDTO> getProducts(Long id) {
        return null;
    }

    @Override
    public List<CartDetailDTO> insertProduct(CartDetailDTO cartDetailDTO, Long id) {
        return null;
    }

    @Override
    public List<CartDetailDTO> updateProduct(CartDetailDTO cartDetailDTO, Long id) {
        return null;
    }

   // @Override
    public List<ProductDTO> insertProduct(ProductDTO productDTO, Long id) {
        List<CartDetail> cartDetails = cartRepository.findOne(id).getProducts();
        boolean isValid = false;
        for (CartDetail cartDetail: cartDetails) {
            if(cartDetail.getProduct().getId() == productDTO.getId()) {
                cartDetail.setQuantity(cartDetail.getQuantity() + 1);
                isValid = true;
                break;
            }
        }
        if(!isValid) {
            //cartDetails.add()
        }
        return null;
    }


    @Override
    public void delete(Long id) {
        cartRepository.delete(id);
    }
}
