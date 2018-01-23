package com.store.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class ProductToCartItem implements Serializable{
    private static final long serialVersionUID = 879172834L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="cart_item_id")
    private CartItem cartItem;

}
