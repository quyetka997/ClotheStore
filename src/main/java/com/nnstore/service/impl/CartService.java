package com.nnstore.service.impl;

import com.nnstore.converter.CartConverter;
import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.CartDTO;
import com.nnstore.dto.CartDetailDTO;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Cart;
import com.nnstore.entity.CartDetail;
import com.nnstore.entity.Product;
import com.nnstore.repository.CartDetailRepository;
import com.nnstore.repository.CartRepository;
import com.nnstore.service.ICartService;
import com.nnstore.service.ICategoryService;
import com.nnstore.service.IProductService;
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

    @Autowired
    CartConverter cartConverter;

    @Autowired
    CartDetailRepository cartDetailRepository;

    @Override
    public CartDTO getCart(Long idCart) {
        Cart cart = cartRepository.findOne(idCart);
        if (cart == null) {
            return null;
        }
        return cartConverter.toDTO(cart);
    }


    @Override
    public List<ProductDTO> getProducts(Long idCart) {
        Cart cart = cartRepository.findOne(idCart);
        if (cart == null) {
            return null;
        }
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (CartDetail cartDetail : cart.getProducts()) {
            ProductDTO productDTO = productConverter.toDTO(cartDetail.getProduct());
            productDTO.setQuantity(cartDetail.getQuantity());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public ProductDTO insertProductToCart(ProductDTO productDTO, Long idCart) {
        Cart cart = cartRepository.findOne(idCart);
        boolean isValid = false;
        if (cart == null) {
            cart = new Cart();
            cart.setId(idCart);
        } else {
            for (CartDetail cartDetail : cart.getProducts()) {
                if (cartDetail.getProduct().getId() == productDTO.getId()) {
                    cartDetail.setQuantity(cartDetail.getQuantity() + productDTO.getQuantity());
                    cartDetailRepository.save(cartDetail);
                    isValid = true;
                    break;
                }
            }
        }

        if (!isValid) {
            cartDetailRepository.save(productConverter.toCartDetailEntity(productDTO, cart));
        }
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long idCart) {
        Cart cart = cartRepository.findOne(idCart);
        for (CartDetail cartDetail : cart.getProducts()) {
            if (cartDetail.getProduct().getId() == productDTO.getId()) {
                cartDetail.setQuantity(productDTO.getQuantity());
                cartDetailRepository.save(cartDetail);
                break;
            }
        }
        return productDTO;
    }


    @Override
    public void deleteProduct(Long productId, Long cartId) {
        Cart cart = cartRepository.findOne(cartId);
        for (CartDetail cartDetail : cart.getProducts()) {
            if (cartDetail.getProduct().getId() == productId) {
                cart.getProducts().remove(cartDetail);
                break;
            }
        }
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = cartRepository.findOne(id);
        cart.setProducts(null);
        cartRepository.delete(id);
    }
}
