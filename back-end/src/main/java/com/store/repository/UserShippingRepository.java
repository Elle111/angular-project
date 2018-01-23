package com.store.repository;

import com.store.domain.UserShipping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link UserShipping}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see UserShipping
 */
@Repository
public interface UserShippingRepository extends CrudRepository<UserShipping, Long> {
}
