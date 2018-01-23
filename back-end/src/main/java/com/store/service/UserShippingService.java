package com.store.service;

import com.store.domain.UserShipping;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link UserShipping}.
 *
 * @author Buchynska S
 * @see UserShipping
 * @see com.store.service.impl.UserShippingServiceImpl
 */
public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
