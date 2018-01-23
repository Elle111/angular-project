package com.store.repository;

import com.store.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link ShoppingCart}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see ShoppingCart
 */
@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
