package com.store.repository;

import com.store.domain.UserBilling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link UserBilling}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see UserBilling
 */
@Repository
public interface UserBillingRepository extends CrudRepository<UserBilling, Long> {
}
