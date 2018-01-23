package com.store.service;

import com.store.domain.Product;

import java.util.List;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link Product}.
 *
 * @author Buchynska S
 * @see Product
 * @see com.store.service.impl.ProductServiceImpl
 */
public interface ProductService {
    List<Product> findAll();

    Product findOne(Long id);

    Product save(Product product);

    List<Product> blurrySearch(String name);

    void removeOne(Long id);
}
