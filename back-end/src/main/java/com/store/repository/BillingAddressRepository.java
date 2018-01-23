package com.store.repository;

import com.store.domain.BillingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link BillingAddress}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see BillingAddress
 */
@Repository
public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long> {
}
