package com.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class ShippingAddress implements Serializable{

    private static final long serialVersionUID = 46784332L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shippingAddressName;
    private String shippingAddressStreet1;
    private String shippingAddressStreet2;
    private String shippingAddressCity;
    private String shippingAddressState;
    private String shippingAddressCountry;
    private String shippingAddressZipcode;

    @OneToOne
    @JsonIgnore
    private Order order;

}
