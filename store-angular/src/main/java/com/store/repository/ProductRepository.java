package com.store.repository;

import com.store.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for class objects {@link Product}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see Product
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameContaining(String keyword);

}
