package com.nnstore.service.impl;

import com.nnstore.converter.ProductConverter;
import com.nnstore.dto.ProductDTO;
import com.nnstore.entity.Product;
import com.nnstore.entity.User;
import com.nnstore.repository.ProductRepository;
import com.nnstore.service.IProductService;
import com.nnstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductConverter productConverter;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    IUserService userService;

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOs = new ArrayList<>();

        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public ProductDTO findOneById(Long id) {
        return productConverter.toDTO(productRepository.findOne(id));
    }

    @Override
    public ProductDTO insert(ProductDTO productDTO) {
        Product result = productConverter.toEntity(productDTO, new Product());
        return productConverter.toDTO(productRepository.save(result));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.getOne(productDTO.getId());

        Product result = productConverter.toEntity(productDTO, product);
        return productConverter.toDTO(productRepository.save(result));
    }

    @Override
    public List<ProductDTO> findAllByNameLike(String like) {
        List<Product> products = productRepository.findAllByNameLike("%" + like + "%");
        List<ProductDTO> productDTOs = new ArrayList<>();
        if (products != null) {
            for (Product product : products) {
                productDTOs.add(productConverter.toDTO(product));
            }
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> findAllByCategoryId(Long id) {
        List<Product> products = productRepository.findAllByCategoryId(id);
        List<ProductDTO> productDTOs = new ArrayList<>();
        if (products != null) {
            for (Product product : products) {
                productDTOs.add(productConverter.toDTO(product));
            }
        }
        return productDTOs;
    }

    @Override
    public List<Product> findAllByOrderDetailId(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> findAllByCategoryIdAndNameLike(Long id, String name) {
        List<Product> products;
        if (name == null) {
            products = productRepository.findAllByCategoryId(id);
        } else {
            products = productRepository.findAllByCategoryIdAndNameLike(id, name);
        }
        List<ProductDTO> productDTOs = new ArrayList<>();
        if (products != null) {
            for (Product product : products) {
                productDTOs.add(productConverter.toDTO(product));
            }
        }
        return productDTOs;
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Long getFavoriteCount(Long id) {
        //return productRepository.getFavoriteCount(id);
        return id;
    }

    @Override
    public Long getViewCount(Long id) {
        //return productRepository.getViewCount(id);
        return id;
    }

    @Override
    public Long getRemindCount(Long id) {
        //return productRepository.getRemindCount(id);
        return id;
    }

    @Override
    public Long getCount() {
        return productRepository.count();
    }

    @Override
    public List<ProductDTO> getFavoriteProducts(Long id) {
        User user = userService.findOne(id);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product: user.getFavoriteProducts()){
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getViewProducts(Long id) {
        User user = userService.findOne(id);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product: user.getViewProducts()){
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getRemindProducts(Long id) {
        User user = userService.findOne(id);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product: user.getRemindProducts()){
            productDTOs.add(productConverter.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public boolean addRemindProductToUser(long productId, long userId) {
        User user = userService.findOne(userId);
        if(addProductToUser(user.getRemindProducts(), productId)){
            userService.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean addFavoriteProductToUser(long productId, long userId) {
        User user = userService.findOne(userId);
        if(addProductToUser(user.getFavoriteProducts(), productId)){
            userService.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean addViewedProductToUser(long productId, long userId) {
        User user = userService.findOne(userId);
        if(addProductToUser(user.getViewProducts(), productId)){
            userService.save(user);
            return true;
        }
        return false;
    }

    public boolean addProductToUser(List<Product> products, long productId) {
        boolean isValid = false;
        for (Product product: products){
            if(product.getId() == productId) {
                isValid = true;
                break;
            }
        }
        if(!isValid) {
            Product currentProduct = productRepository.findOne(productId);
            products.add(currentProduct);
            return true;
        } else {
            return false;
        }
    }
}
