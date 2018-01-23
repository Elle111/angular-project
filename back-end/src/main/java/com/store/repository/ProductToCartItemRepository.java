package com.store.repository;

import com.store.domain.CartItem;
import com.store.domain.ProductToCartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link ProductToCartItem}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see ProductToCartItem
 */
@Repository
public interface ProductToCartItemRepository extends CrudRepository<ProductToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
