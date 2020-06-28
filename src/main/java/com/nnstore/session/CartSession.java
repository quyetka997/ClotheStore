package com.nnstore.session;

import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Product;
import com.nnstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope //Name cartSession
@Component
public class CartSession {
    @Autowired
    IProductService productService;

    Map<Long, ProductDTO> map = new HashMap<>();

    public void add(Long id) {
        ProductDTO product = map.get(id);
        if (product == null) {
            ProductDTO productDTO = productService.findOneById(id);
            productDTO.setQuantity(1);
            map.put(id, productDTO);
        } else {
            product.setQuantity(product.getQuantity() + 1);
        }
    }
    public void remove(Long id) {
        map.remove(id);
    }

    public void update(Long id, ProductDTO productDTO) {
        map.put(id,productDTO);
    }

    public void clear() {
        map.clear();
    }

    public Integer getCount() {
        Collection<ProductDTO> productDTOs = this.getItems();
        int count = 0;
        for (ProductDTO product:productDTOs) {
            count += product.getQuantity();
        }
        return count;
    }

    public Double getAmount() {
        Collection<ProductDTO> productDTOs = this.getItems();
        double sum = 0;
        for (ProductDTO productDTO: productDTOs) {
            sum += productDTO.getQuantity() * productDTO.getPrice();
        }
        return sum;
    }

    public Collection<ProductDTO> getItems() {
        return map.values();
    }
}
