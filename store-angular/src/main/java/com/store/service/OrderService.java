package com.store.service;

import com.store.domain.*;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link Order}.
 *
 * @author Buchynska S
 * @see Order
 * @see com.store.service.impl.OrderServiceImpl
 */
public interface OrderService {
    Order createOrder(
            ShoppingCart shoppingCart,
            ShippingAddress shippingAddress,
            BillingAddress billingAddress,
            Payment payment,
            String shippingMethod,
            User user
    );
}
