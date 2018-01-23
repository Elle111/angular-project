package com.store.service;

import com.store.domain.UserPayment;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link UserPayment}.
 *
 * @author Buchynska S
 * @see UserPayment
 * @see com.store.service.impl.UserPaymentServiceImpl
 */
public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
