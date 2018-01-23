package com.store.repository;

import com.store.domain.Order;
import com.store.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for class objects {@link Order}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see Order
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUser(User user);

}
