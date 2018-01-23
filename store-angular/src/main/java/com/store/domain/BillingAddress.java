package com.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class BillingAddress implements Serializable{

    private static final long serialVersionUID = 7995338L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String billingAddressName;
    private String billingAddressStreet1;
    private String billingAddressStreet2;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressCountry;
    private String billingAddressZipcode;

    @OneToOne
    @JsonIgnore
    private Order order;

}
