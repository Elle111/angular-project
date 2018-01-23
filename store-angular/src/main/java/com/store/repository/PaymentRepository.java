package com.store.repository;

import com.store.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link Payment}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see Payment
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{
}
