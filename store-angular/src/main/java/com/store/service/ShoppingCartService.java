package com.store.service;

import com.store.domain.ShoppingCart;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link ShoppingCart}.
 *
 * @author Buchynska S
 * @see ShoppingCart
 * @see com.store.service.impl.ShoppingCartServiceImpl
 */
public interface ShoppingCartService {

    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);


}
