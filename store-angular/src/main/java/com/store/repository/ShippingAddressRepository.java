package com.store.repository;

import com.store.domain.ShippingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link ShippingAddress}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see ShippingAddress
 */
@Repository
public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
}
