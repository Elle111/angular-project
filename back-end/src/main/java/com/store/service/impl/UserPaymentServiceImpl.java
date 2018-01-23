package com.store.service.impl;

import com.store.domain.UserPayment;
import com.store.repository.UserPaymentRepository;
import com.store.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer class implements access methods for class objects {@link UserPayment}
 * in the interface database {@link UserPaymentService}.
 * Class is marked with an annotation @Service - annotation that this class represents
 * The service itself is a service-layer component. Service is a subtype of class @Component.
 * Using this annotation will allow you to search for Beans -services automatically.
 *
 * @author Buchynska S
 * @see UserPaymentService
 * @see UserPayment
 * @see UserPaymentRepository
 */
@Service
public class UserPaymentServiceImpl implements UserPaymentService{

    @Autowired
    private UserPaymentRepository userPaymentRepository;
    @Override
    public UserPayment findById(Long id) {
        return userPaymentRepository.findOne(id);
    }

    @Override
    public void removeById(Long id) {
        userPaymentRepository.delete(id);
    }
}
