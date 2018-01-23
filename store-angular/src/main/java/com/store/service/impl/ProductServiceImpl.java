package com.store.service.impl;

import com.store.domain.Product;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer class implements access methods for class objects {@link Product}
 * in the interface database {@link ProductService}.
 * Class is marked with an annotation @Service - annotation that this class represents
 * The service itself is a service-layer component. Service is a subtype of class @Component.
 * Using this annotation will allow you to search for Beans -services automatically.
 *
 * @author Buchynska S
 * @see ProductService
 * @see Product
 * @see ProductRepository
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> productList = (List<Product>) productRepository.findAll();

        List<Product> activeProductList = new ArrayList<>();

        for (Product product : productList) {
            if(product.isActive()) {
                activeProductList.add(product);
            }
        }

        return activeProductList;
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> blurrySearch(String keyword) {
        List<Product> productList = productRepository.findByNameContaining(keyword);

        List<Product> activeProductList = new ArrayList<>();

        for (Product product : productList) {
            if(product.isActive()) {
                activeProductList.add(product);
            }
        }

        return activeProductList;
    }

    @Override
    public void removeOne(Long id) {
        productRepository.delete(id);
    }
}
