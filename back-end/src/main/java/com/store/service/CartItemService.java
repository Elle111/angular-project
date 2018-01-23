package com.store.service;

import com.store.domain.CartItem;
import com.store.domain.Product;
import com.store.domain.ShoppingCart;
import com.store.domain.User;

import java.util.List;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link CartItem}.
 *
 * @author Buchynska S
 * @see CartItem
 * @see com.store.service.impl.CartItemServiceImpl
 */
public interface CartItemService {
    CartItem addProductToCartItem(Product product, User user, int qty);

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//	List<CartItem> findByOrder(Order order);

    CartItem updateCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem findById(Long id);

    CartItem save(CartItem cartItem);

}
