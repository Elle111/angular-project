package com.store.service.impl;

import com.store.domain.UserShipping;
import com.store.repository.UserShippingRepository;
import com.store.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer class implements access methods for class objects {@link UserShipping}
 * in the interface database {@link UserShippingService}.
 * Class is marked with an annotation @Service - annotation that this class represents
 * The service itself is a service-layer component. Service is a subtype of class @Component.
 * Using this annotation will allow you to search for Beans -services automatically.
 *
 * @author Buchynska S
 * @see UserShippingService
 * @see UserShipping
 * @see UserShippingRepository
 */
@Service
public class UserShippingServiceImpl implements UserShippingService{
    @Autowired
    private UserShippingRepository userShippingRepository;

    @Override
    public UserShipping findById(Long id) {
        return userShippingRepository.findOne(id);
    }

    @Override
    public void removeById(Long id) {
        userShippingRepository.delete(id);
    }
}
