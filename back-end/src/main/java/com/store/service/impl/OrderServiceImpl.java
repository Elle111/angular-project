package com.store.service.impl;

import com.store.domain.*;
import com.store.repository.BillingAddressRepository;
import com.store.repository.OrderRepository;
import com.store.repository.PaymentRepository;
import com.store.repository.ShippingAddressRepository;
import com.store.service.CartItemService;
import com.store.service.OrderService;
import com.store.service.ProductService;
import com.store.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Service layer class implements access methods for class objects {@link Order}
 * in the interface database {@link OrderService}.
 * Class is marked with an annotation @Service - annotation that this class represents
 * The service itself is a service-layer component. Service is a subtype of class @Component.
 * Using this annotation will allow you to search for Beans -services automatically.
 *
 * @author Buchynska S
 * @see OrderService
 * @see Order
 * @see OrderRepository
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MailConstructor mailConstructor;

    @Override
    public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress, Payment payment, String shippingMethod, User user) {
        Order order = new Order();
        order.setBillingAddress(billingAddress);
        order.setOrderStatus("created");
        order.setPayment(payment);
        order.setShippingAddress(shippingAddress);
        order.setShippingMethod(shippingMethod);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            Product product = cartItem.getProduct();
            cartItem.setOrder(order);
            product.setInStockNumber(product.getInStockNumber()-cartItem.getQty());
        }

        order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderTotal(shoppingCart.getGrandTotal());
        shippingAddress.setOrder(order);
        billingAddress.setOrder(order);
        payment.setOrder(order);
        order.setUser(user);
        order = orderRepository.save(order);

        return order;

    }

    public Order findOne(Long id) {
        return orderRepository.findOne(id);
    }

}
