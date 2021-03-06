package com.store.repository;

import com.store.domain.UserPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link UserPayment}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see UserPayment
 */
@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {
}
