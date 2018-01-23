package com.store.repository;

import com.store.domain.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class objects {@link Role}, providing
 * set of methods JPA to work with the database. Inherits interface {@link CrudRepository}.
 *
 * @author Buchynska S
 * @see CrudRepository
 * @see Role
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
}
